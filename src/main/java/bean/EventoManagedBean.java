/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import entidade.Setor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jpa.EventoJPA;
import jpa.SetorJPA;

/**
 *
 * @author Leal
 */
@Named(value = "eventoManagedBean")
@SessionScoped
public class EventoManagedBean implements Serializable {

    private ArrayList<Evento> eventos;
    private Evento evento;

    /**
     * @return the eventos
     */
    public EventoManagedBean() {
        evento = new Evento();
    }

    public ArrayList<Evento> getEventos() {

        eventos = new ArrayList<>();

        EventoJPA eventoJPA = new EventoJPA();
        SetorJPA setorJPA = new SetorJPA();

        List<Evento> evs = eventoJPA.carregaEventos();
        List<Setor> setores = setorJPA.carregaSetores();

        for (int i = 0; i < evs.size(); i++) {
            eventos.add(evs.get(i));

            for (int j = 0; j < setores.size(); j++) {

                if (setores.get(j).getId_evento().getId_evento() == eventos.get(i).getId_evento()) {

                    if (!eventos.get(i).getSetores().contains(setores.get(j))) {
                        eventos.get(i).addSetores(setores.get(j));
                    }

                }
                break;
            }

            /*for (Setor setore : setores) {
             if (setore.getId_evento().getId_evento() == eventos.get(i).getId_evento()) {
             if (!evs.get(i).getSetores().contains(setore)) {
             eventos.get(i).addSetores(setore);
             }
             }
             }*/
        }
        return eventos;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public int getTamanhoArray() {
        return eventos.size();
    }

    public String cadastrar() {
        //eventoDAO.addEvento(evento);
        return "menu";
    }

}
