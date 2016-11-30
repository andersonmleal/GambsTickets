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
    private String mensagem;

    public DetalheManagedBean() {

    }

    public String getMensagem() {
        return mensagem;
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
        this.mensagem = "";
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

        //add inteira
        for (String inteira : ingressosInteira) {

            // divide string
            String[] tInteira = inteira.split(",");
            //captura dados
            int quantidadeInteira = Integer.parseInt(tInteira[0]);
            int idSetorInteira = Integer.parseInt(tInteira[1]);

            for (int i = 0; i < evento.getSetores().size(); i++) {
                if (evento.getSetores().get(i).getIdSetor() == idSetorInteira) {
                    EventoIngressos eventInteira = new EventoIngressos(evento.getSetores().get(i), evento, quantidadeInteira);
                    eventInteira.setPrecoUnitario(eventInteira.getSetor().getPreco());
                    ev.add(eventInteira);
                }
            }

        }

        //add meia entrada
        for (String meia : ingressosMeia) {

            // divide string
            String[] tMeia = meia.split(",");
            //captura dados            
            int quantidadeMeia = Integer.parseInt(tMeia[0]);
            int idSetorMeia = Integer.parseInt(tMeia[1]);

            for (int i = 0; i < evento.getSetores().size(); i++) {
                if (evento.getSetores().get(i).getIdSetor() == idSetorMeia) {
                    EventoIngressos eventMeia = new EventoIngressos(evento.getSetores().get(i), evento, quantidadeMeia);
                    eventMeia.setPrecoUnitario(eventMeia.getSetor().getPreco() / 2);
                    ev.add(eventMeia);
                }
            }

        }

        //CarrinhoManagedBean carrinho = new CarrinhoManagedBean();
        //carrinho.setEventos(ev);
        return ev;

    }

    public String validaSelecao() {

        if (ingressosInteira.isEmpty() && ingressosMeia.isEmpty()) {
            this.mensagem = "Favor selecionar ingressos";
            return "";
        } else {
            return "carrinhoCompras.xhtml";
        }
    }

}
