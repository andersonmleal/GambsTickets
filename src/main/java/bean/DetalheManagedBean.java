/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import entidade.EventoIngressos;
import entidade.Setor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leal
 */
@Named(value = "detalheManagedBean")
@SessionScoped
public class DetalheManagedBean implements Serializable {

    /**
     * Creates a new instance of DetalheManagedBean
     */
    private Evento evento;
    private String ingressoIntSelecionado;
    private String ingressoMeiaSelecionado;
    private List<EventoIngressos> evIngressos;

    public DetalheManagedBean() {
        evIngressos = new ArrayList<>();

    }

    public String getIngressoIntSelecionado() {
        return ingressoIntSelecionado;
    }

    public void setIngressoIntSelecionado(String ingressoIntSelecionado) {
        this.ingressoIntSelecionado = ingressoIntSelecionado;
    }

    public String getIngressoMeiaSelecionado() {
        return ingressoMeiaSelecionado;
    }

    public void setIngressoMeiaSelecionado(String ingressoMeiaSelecionado) {
        this.ingressoMeiaSelecionado = ingressoMeiaSelecionado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;

        for (int i = 0; i < evento.getSetores().size(); i++) {

            Setor setor;
            setor = evento.getSetores().get(i);
            EventoIngressos ev = new EventoIngressos(setor);
            evIngressos.add(ev);
        }

    }

    public List<EventoIngressos> getEvIngressos() {
        return evIngressos;
    }

    public void setEvIngressos(List<EventoIngressos> evIngressos) {
        this.evIngressos = evIngressos;
    }

}
