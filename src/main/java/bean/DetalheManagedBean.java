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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;

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
    private List<String> ingressosMeia;
    private List<String> ingressosInteira;
    private List<EventoIngressos> evIngressos;
    //private List<EventoIngressos> ev;

    public DetalheManagedBean() {
        
    }
    
    public String getIngressoIntSelecionado() {
        return ingressoIntSelecionado;
    }
    
    public List<String> getIngressosMeia() {
        return ingressosMeia;
    }
    
    public List<String> getIngressosInteira() {
        return ingressosInteira;
    }
    
    public void setIngressoIntSelecionado(String ingressoIntSelecionado) {
        this.ingressoIntSelecionado = ingressoIntSelecionado;
        
        if (!ingressoIntSelecionado.contains("0,")) {
            this.ingressosInteira.add(this.ingressoIntSelecionado);
        }
        
    }
    
    public String getIngressoMeiaSelecionado() {
        return ingressoMeiaSelecionado;
    }
    
    public void setIngressoMeiaSelecionado(String ingressoMeiaSelecionado) {
        this.ingressoMeiaSelecionado = ingressoMeiaSelecionado;
        
        if (!ingressoMeiaSelecionado.contains("0,")) {
            this.ingressosMeia.add(ingressoMeiaSelecionado);
        }
    }
    
    public Evento getEvento() {
        return evento;
    }
    
    public void setEvento(Evento evento) {
        this.ingressoIntSelecionado = null;
        this.ingressoMeiaSelecionado = null;
        this.evento = new Evento();
        this.evento = evento;
        this.ingressosMeia = new ArrayList<>();
        this.ingressosInteira = new ArrayList<>();
        this.evIngressos = new ArrayList<>();
        //this.ev = new ArrayList<>();

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
    
    public List<EventoIngressos> adicionarCarrinho() {
        
        List<EventoIngressos> ev = new ArrayList<>();

        //add meia entrada
        for (String meia : ingressosMeia) {

            // divide string
            String[] t = meia.split(",");
            //captura dados            
            int quantidade = Integer.parseInt(t[0]);
            int idSetor = Integer.parseInt(t[1]);
            
            EventoIngressos even = new EventoIngressos(evento.getSetores().get(idSetor - 1), evento, quantidade);
            //even.getSetor().setPreco(even.getSetor().getPreco() / 2);
            ev.add(even);
        }

        //add inteira
        for (String inteira : ingressosInteira) {

            // divide string
            String[] t = inteira.split(",");
            //captura dados
            int quantidade = Integer.parseInt(t[0]);
            int idSetor = Integer.parseInt(t[1]);
            
            EventoIngressos event = new EventoIngressos(evento.getSetores().get(idSetor - 1), evento, quantidade);
            ev.add(event);
        }

        //CarrinhoManagedBean carrinho = new CarrinhoManagedBean();
        //carrinho.setEventos(ev);
        return ev;
        
    }

    //public List<EventoIngressos> getEv() {
    //   return ev;
    // }
}
