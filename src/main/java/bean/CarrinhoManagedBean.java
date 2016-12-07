/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.EventoIngressos;
import entidade.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import jpa.UsuarioJPA;

/**
 *
 * @author Leal
 */
@Named(value = "CarrinhoManagedBean")
@SessionScoped
public class CarrinhoManagedBean implements Serializable {

    private List<EventoIngressos> eventos;
    private String etapaCompra;
    private String mensagem;
    private EventoIngressos removerItem;
    private Usuario usuario = null;
    private String cpf;
    private String senha;
    private boolean compraConcluida;

    public CarrinhoManagedBean() {

        eventos = new ArrayList<>();
        etapaCompra = "etapaCompra-itensCarrinho.xhtml";
    }

    public EventoIngressos getRemoverItem() {
        return removerItem;
    }

    public void setRemoverItem(EventoIngressos removerItem) {
        this.eventos.remove(removerItem);
        this.mensagem = "Ingressos removidos";
    }

    public List<EventoIngressos> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoIngressos> eventos) {

        this.mensagem = "";
        int cont;

        for (int i = 0; i < eventos.size(); i++) {
            cont = 0;

            for (int j = 0; j < this.eventos.size(); j++) {
                if (//verifica se ja existe ingressos com mesmo nome de evento
                        eventos.get(i).getEvento().getNome_evento().equals(this.eventos.get(j).getEvento().getNome_evento())
                        //verifica se ja existe ingressos com mesmo nome de setor
                        && eventos.get(i).getSetor().getNomeSetor().equals(this.eventos.get(j).getSetor().getNomeSetor())
                        //verifica se ja existe ingressos com mesmo preco
                        && eventos.get(i).getPrecoUnitario() == this.eventos.get(j).getPrecoUnitario()) {

                    cont++;
                    this.mensagem = "Já existem ingresso selecionados para um dos setores. Os mesmos não foram adicionados.";
                }
            }
            if (cont == 0) {
                this.eventos.add(eventos.get(i));
            }
        }

    }

    public Usuario recuperaUsuario() {
        //ServletRequest req = null;
        //HttpServletRequest request = (HttpServletRequest) req;
        //HttpSession session = (HttpSession) request.getSession();

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        usuario = (Usuario) session.getAttribute("usuario");

        //JOptionPane.showInputDialog(UsuarioSession);
        return usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getTamanhoArray() {
        return eventos.size();
    }

    public String concluir() {
        String retorno;
        ConclusaoCompraManagedBean conclui = new ConclusaoCompraManagedBean();
        retorno = conclui.concluirCompra();
        compraConcluida = true;
        return retorno;
    }

    public String getEtapaCompra() {
        if (etapaCompra == null || compraConcluida) {
            compraConcluida = false;
            etapaCompra = "etapaCompra-itensCarrinho.xhtml";
        }
        return etapaCompra;
    }

    public void setEtapaCompra(String etapaCompra) {
        this.etapaCompra = etapaCompra;
    }

    public Usuario validarUsuario(String cpf, String senha) {
        UsuarioJPA usuarioJPA = new UsuarioJPA();
        long usuarioLng = Long.parseLong(cpf);
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);
        if (user.isEmpty()) {
            return null;
        } else {

            return user.get(0);
            //return usuarioLng == user.get(0).getCpf() && senha.equals(user.get(0).getSenha());
        }
        //ConclusaoCompraManagedBean userBean = new ConclusaoCompraManagedBean();
        //userBean.setUsuario(user.get(0));

    }

    public String realizarLogin() {
        usuario = validarUsuario(cpf, senha);

        if (usuario != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", usuario);
            etapaCompra = "etapaCompra-itensCarrinho.xhtml";
            return "carrinhoCompras";

        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Erro de Login", "Usuario/Senha inválidos");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "loginErro";
    }

    public void proximaEtapa(int etapaAtual) {
        switch (etapaAtual) {
            case 1:
                if (recuperaUsuario() != null || etapaCompra.contains("erroLogin")) {

                    if (etapaCompra.contains("resumoCompra")) {
                        etapaCompra = "etapaCompra-itensCarrinho.xhtml";
                        break;
                    } else {
                        etapaCompra = "etapaCompra-enderecoEntrega.xhtml";
                        break;
                    }
                } else {
                    etapaCompra = "etapaCompra-erroLogin.xhtml";
                    break;
                }

            case 2:
                if (recuperaUsuario() != null || etapaCompra.contains("erroLogin")) {

                    if (etapaCompra.contains("resumoCompra")) {
                        etapaCompra = "etapaCompra-itensCarrinho.xhtml";
                        break;
                    } else {
                        etapaCompra = "etapaCompra-formaPagamento.xhtml";
                        break;
                    }

                } else {
                    etapaCompra = "etapaCompra-erroLogin.xhtml";
                    break;
                }

            case 3:
                if (recuperaUsuario() != null || etapaCompra.contains("erroLogin")) {
                    if (etapaCompra.contains("resumoCompra") || etapaCompra.equals("etapaCompra-resumoCompra.xhtml")) {
                        etapaCompra = "etapaCompra-itensCarrinho.xhtml";
                        break;
                    } else {
                        etapaCompra = "etapaCompra-resumoCompra.xhtml";
                        break;
                    }
                } else {
                    etapaCompra = "etapaCompra-erroLogin.xhtml";
                    break;
                }

        }
    }

    public void voltarEtapa(int etapaAtual) {
        switch (etapaAtual) {
            case 2:
                etapaCompra = "etapaCompra-itensCarrinho.xhtml";
                break;

            case 3:
                etapaCompra = "etapaCompra-enderecoEntrega.xhtml";
                break;

            case 4:
                etapaCompra = "etapaCompra-formaPagamento.xhtml";
                break;

        }
    }

    public String verificaIngressos() {

        if (this.eventos.isEmpty()) {
            return "true";
        } else {
            return "false";
        }
    }

    public String verificaIngressosMensagem() {

        if (this.eventos.isEmpty()) {
            return "O carrinho está vazio. Adicione ingressos para prosseguir.";
        } else {
            return "";
        }
    }

    public Object retornaClasse() throws CloneNotSupportedException {
        return this.clone();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCompraConcluida() {
        return compraConcluida;
    }

    public void setCompraConcluida(boolean compraConcluida) {
        this.compraConcluida = compraConcluida;
    }

    public void limpaDados() {

        eventos = null;
        etapaCompra = null;
        mensagem = null;
        removerItem = null;
        usuario = null;
        cpf = null;
        senha = null;
        compraConcluida = false;

    }
}
