/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import entidade.Evento;
import entidade.FormaPagamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

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
    private List<Evento> eventosSelecionados;
    private Endereco endereco;
    private FormaPagamento pagamento; 

    public ConclusaoCompraManagedBean() {

        eventosSelecionados = new ArrayList<>();

    }

    public List<Evento> getEventosSelecionados() {
        return eventosSelecionados;
    }

    public void setEventosSelecionados(List<Evento> eventosSelecionados) {
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
    }
    



}
