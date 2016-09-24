/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author anderson.mleal
 */
@ManagedBean
public class EventoBean {

    private String nomeEvento;
    private String caminhoImagem;
    private String descricao;
    private ArrayList<EventoBean> eventos;

    public EventoBean() {
    }

    /**
     * @return the nomeEvento
     */
    public String getNomeEvento() {
        return nomeEvento;
    }

    /**
     * @param nomeEvento the nomeEvento to set
     */
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    /**
     * @return the caminhoImagem
     */
    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    /**
     * @param caminhoImagem the caminhoImagem to set
     */
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the eventos
     */
    public ArrayList<EventoBean> getEventos() {

            eventos = new ArrayList<>();
        
            
            EventoBean ev = new EventoBean();
            
            ev.setNomeEvento("NovoNome1");
            ev.setCaminhoImagem("img\\01.jpg");
            ev.setDescricao("descricao_1");

            eventos.add(ev);
            
            EventoBean ev2 = new EventoBean();
            
            ev2.setNomeEvento("NovoNome2");
            ev2.setCaminhoImagem("img\\02.png");
            ev2.setDescricao("descricao_2");

            eventos.add(ev2);
            
            EventoBean ev3 = new EventoBean();
            
            ev3.setNomeEvento("NovoNome3");
            ev3.setCaminhoImagem("img\\03.png");
            ev3.setDescricao("descricao_3");

            eventos.add(ev3);
        
            EventoBean ev4 = new EventoBean();
            
            ev4.setNomeEvento("NovoNome4");
            ev4.setCaminhoImagem("img\\03.png");
            ev4.setDescricao("descricao_4");

            eventos.add(ev4);

        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(ArrayList<EventoBean> eventos) {
        this.eventos = eventos;
    }

    public int getTamanhoArray() {
        return eventos.size();
    }

}
