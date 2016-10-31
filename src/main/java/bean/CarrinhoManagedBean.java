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
@Named(value = "CarrinhoManagedBean")
@SessionScoped
public class CarrinhoManagedBean implements Serializable {

    private ArrayList<Evento> eventos;
    private String etapaCompra;

    public CarrinhoManagedBean() {

        eventos = new ArrayList<>();

    }

    public boolean addCarrinho(Evento ev) {

        try {
            eventos.add(ev);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    /**
     * @return the eventos
     */
    public ArrayList<Evento> getEventos() {
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

    public String getEtapaCompra() {
        etapaCompra = "enderecoEntrega.xhtml";
        return etapaCompra;
    }

    public void setEtapaCompra(String etapaCompra) {
        this.etapaCompra = etapaCompra;
    }
    

}
