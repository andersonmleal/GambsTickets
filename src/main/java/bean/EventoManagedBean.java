/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Leal
 */
@Named(value = "eventoManagedBean")
@SessionScoped
public class EventoManagedBean implements Serializable {

    private ArrayList<Evento> eventos;

    /**
     * @return the eventos
     */
    public ArrayList<Evento> getEventos() {

        eventos = new ArrayList<>();

        Evento ev = new Evento();

        ev.setId_evento(0);
        ev.setNome_evento("NovoNome1");
        ev.setCaminhoImagem("img\\01.jpg");
        ev.setDescricao("descricao_1");

        eventos.add(ev);

        Evento ev2 = new Evento();

        ev2.setId_evento(2);
        ev2.setNome_evento("NovoNome2");
        ev2.setCaminhoImagem("img\\02.png");
        ev2.setDescricao("descricao_2");

        eventos.add(ev2);

        Evento ev3 = new Evento();

        ev3.setId_evento(3);
        ev3.setNome_evento("NovoNome3");
        ev3.setCaminhoImagem("img\\03.png");
        ev3.setDescricao("descricao_3");

        eventos.add(ev3);

        Evento ev4 = new Evento();

        ev4.setId_evento(4);
        ev4.setNome_evento("NovoNome4");
        ev4.setCaminhoImagem("img\\03.png");
        ev4.setDescricao("descricao_4");

        eventos.add(ev4);

        return eventos;
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

    public EventoManagedBean() {
    }


}
