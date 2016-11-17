/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import entidade.Evento;
import entidade.EventoIngressos;
import entidade.FormaPagamento;
import entidade.Usuario;
import entidade.Venda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.EnderecoJPA;
import jpa.EventoJPA;
import jpa.FormaPagamentoJPA;
import jpa.SetorJPA;
import jpa.UsuarioJPA;
import jpa.VendaJPA;

/**
 *
 * @author Anderson
 */
@Named(value = "conclusaoCompraManagedBean")
@SessionScoped
public class ConclusaoCompraManagedBean implements Serializable {

    /**
     * Creates a new instance of ConclusaoCompraManagedBean
     */
    private List<EventoIngressos> eventosSelecionados;
    private Endereco endereco;
    private FormaPagamento pagamento;
    private long numCartao;
    private double valorTotal;
    private Usuario usuario;

    public ConclusaoCompraManagedBean() {

        eventosSelecionados = new ArrayList<>();

    }

    public List<EventoIngressos> getEventosSelecionados() {
        return eventosSelecionados;
    }

    public void setEventosSelecionados(List<EventoIngressos> eventosSelecionados) {
        this.eventosSelecionados = eventosSelecionados;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
        this.numCartao = pagamento.getNumCartao();
    }

    public long getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    public double getValorTotal() {

        for (EventoIngressos ev : eventosSelecionados) {

            valorTotal = valorTotal + ev.getPrecoTotal();
        }

        return valorTotal;
    }

    public boolean concluirCompra() {
        Venda venda = new Venda();
        //long usuarioLng;
        LoginBean login = new LoginBean();
        Usuario user = login.recuperaUsuario();
        //UsuarioJPA usuarioJPA = new UsuarioJPA();
        //if (user.equals("")) {
        //    usuarioLng = 76;
        //} else {
        //    usuarioLng = Long.parseLong(user);
        //}
        //List<Usuario> userList = usuarioJPA.verificaCadastro(usuarioLng);

        Calendar c = Calendar.getInstance();
        int contador = 0;
        for (EventoIngressos ev : eventosSelecionados) {

            cadastrarEvento(c, ev.getEvento());
            endereco.setDt_cadastro(c.getTime());
            endereco.setUsuario_evento(user);
            EnderecoJPA enderecoJPA = new EnderecoJPA();
            enderecoJPA.incluir(endereco);
            //EnderecoManagedBean enderecoBean = new EnderecoManagedBean();
            //enderecoBean.cadastrar(userList.get(0));
            //pagamento.setId_venda(venda);
            pagamento.setBandeira("masterCard");
            FormaPagamentoJPA formaPagamentoJPA = new FormaPagamentoJPA();
            formaPagamentoJPA.incluir(pagamento);
            cadastrarVenda(c, contador, user, venda);
            contador++;
        }
        return false;
    }

    private void cadastrarVenda(Calendar c, int contador, Usuario user, Venda venda) {
        VendaJPA vendaJPA = new VendaJPA();
        venda.setId_setor(eventosSelecionados.get(contador).getSetor());
        venda.setUsuario(user);
        venda.setId_endereco(endereco);
        venda.setFormaPagamento(pagamento);
        venda.setQuantidade(eventosSelecionados.get(contador).getQuantidadeSelecionada());
        venda.setDt_cadastro(c.getTime());
        vendaJPA.incluir(venda);

    }

    private void cadastrarEvento(Calendar c, Evento ev) {
        EventoJPA eventoJPA = new EventoJPA();
        SetorJPA setorJPA = new SetorJPA();
        for (int i = 0; i < ev.getSetores().size(); i++) {
            //ev.getSetores().get(i).setId_evento(ev);
            ev.getSetores().get(i).setDt_cadastro(c.getTime());
            setorJPA.incluir(ev.getSetores().get(i));
        }
        ev.setDt_cadastro_evento(c.getTime());
        ev.setLocal_evento("teste");
        ev.setDt_evento(c.getTime());
        ev.setDescricao("Show Muito loko");
        eventoJPA.incluir(ev);

    }
}
