/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import jpa.UsuarioJPA;

/**
 *
 * @author Thiago
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String cpf;
    private String senha;
    private String nome = "";
    private Usuario usuario = null;
    private boolean logado = false;
    //private String UsuarioSession = null;

    public LoginBean() {

    }

    public String realizarLogin() {

        if (cpf.isEmpty() || cpf == null
                || senha.isEmpty() || senha == null) {

            return "loginErro.xhtml";

        } else {
            usuario = validarUsuario(cpf, senha);

            if (usuario != null) {
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("usuario", usuario);
                int nivel = usuario.getTipo_usuario();
                if (nivel == 1) {
                    logado = true;
                }
                return "index";
            }

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro de Login", "Usuario/Senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "loginErro";
        }

    }

    public String realizarLoginErro() {
        usuario = validarUsuario(cpf, senha);

        if (usuario != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", usuario);
            return "etapaCompra-itensCarrinho";
        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Erro de Login", "Usuario/Senha inválidos");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "loginErro";
    }

    public String realizarLogout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "index.xhtml";
    }

    public Usuario recuperaUsuario() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

        usuario = (Usuario) session.getAttribute("usuario");

        //JOptionPane.showInputDialog(UsuarioSession);
        return usuario;
    }

    public Usuario validarUsuario(String cpf, String senha) {
        UsuarioJPA usuarioJPA = new UsuarioJPA();
        long usuarioLng = Long.parseLong(cpf);
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);

        if (user.isEmpty()) {
            return null;
        } else if (!user.get(0).getSenha().equals(senha)) {
            return null;
        } else {

            return user.get(0);
            //return usuarioLng == user.get(0).getCpf() && senha.equals(user.get(0).getSenha());
        }
        //ConclusaoCompraManagedBean userBean = new ConclusaoCompraManagedBean();
        //userBean.setUsuario(user.get(0));

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return logado;
    }

}
