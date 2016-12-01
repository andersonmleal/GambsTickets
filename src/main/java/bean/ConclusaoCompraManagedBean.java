/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import entidade.EventoIngressos;
import entidade.FormaPagamento;
import entidade.Usuario;
import entidade.Venda;
import bean.CarrinhoManagedBean;
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

    public String concluirCompra() {
        Venda venda = new Venda();
        
        LoginBean login = new LoginBean();
        Usuario user = login.recuperaUsuario();

        Calendar c = Calendar.getInstance();
        int contador = 0;
        for (EventoIngressos ev : eventosSelecionados) {
            endereco.setDt_cadastro(c.getTime());
            endereco.setUsuario_evento(user);
            EnderecoJPA enderecoJPA = new EnderecoJPA();
            enderecoJPA.incluir(endereco);
            pagamento.setBandeira("masterCard");
            FormaPagamentoJPA formaPagamentoJPA = new FormaPagamentoJPA();
            formaPagamentoJPA.incluir(pagamento);
            cadastrarVenda(c, contador, user, venda);
            contador++;
        }
        CarrinhoManagedBean carrinho = new CarrinhoManagedBean();
        carrinho.setCompraConcluida(true);
        return "conclusao.xhtml";
    }

    private void cadastrarVenda(Calendar c, int contador, Usuario user, Venda venda) {
        VendaJPA vendaJPA = new VendaJPA();
        venda.setId_setor(eventosSelecionados.get(contador).getSetor());
        venda.setUsuario(user);
        venda.setId_endereco(endereco);
        venda.setFormaPagamento(pagamento);
        venda.setQuantidade(eventosSelecionados.get(contador).getQuantidadeSelecionada());
        venda.setDt_cadastro(c.getTime());
        venda.setValor(valorTotal);
        vendaJPA.incluir(venda);

    }

}
