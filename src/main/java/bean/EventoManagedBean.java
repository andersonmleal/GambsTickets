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
        ev.setCaminhoImagemBack("img\\01_back.jpg");
        ev.setDescricao("descricao_1");
        
        Setor set = new Setor("Pista", 150.00, 5000);
        ev.addSetores(set);
        Setor set1 = new Setor("Cadeira Inferior", 200.00, 5000);
        ev.addSetores(set1);
        Setor set2 = new Setor("Cadeira Superior", 100.00, 5000);
        ev.addSetores(set2);
        
        
        eventos.add(ev);

        Evento ev2 = new Evento();

        ev2.setId_evento(2);
        ev2.setNome_evento("NovoNome2");
        ev2.setCaminhoImagem("img\\02.png");
        ev2.setCaminhoImagemBack("img\\02_back.jpg");
        ev2.setDescricao("descricao_2");
        
        Setor set4 = new Setor("Pista Premium", 300.00, 5000);
        ev2.addSetores(set4);
        Setor set5 = new Setor("Pista", 120.00, 5000);
        ev2.addSetores(set5);
        Setor set6 = new Setor("Cadeira", 200.00, 5000);
        ev2.addSetores(set6);

        eventos.add(ev2);

        Evento ev3 = new Evento();

        ev3.setId_evento(3);
        ev3.setNome_evento("NovoNome3");
        ev3.setCaminhoImagem("img\\03.png");
        ev3.setCaminhoImagemBack("img\\03_back.jpg");
        ev3.setDescricao("descricao_3");
        
        Setor set7 = new Setor("Pista", 220.00, 5000);
        ev3.addSetores(set7);
        Setor set8 = new Setor("Cadeira", 180.00, 5000);
        ev3.addSetores(set8);

        eventos.add(ev3);

        Evento ev4 = new Evento();

        ev4.setId_evento(4);
        ev4.setNome_evento("NovoNome4");
        ev4.setCaminhoImagem("img\\03.png");
        ev4.setCaminhoImagemBack("img\\03_back.jpg");
        ev4.setDescricao("descricao_4");

        Setor set9 = new Setor("Cadeira", 180.00, 5000);
        ev4.addSetores(set9);
        
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
