/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import entidade.EventoIngressos;
import entidade.FormaPagamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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

}
