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

    public DetalheManagedBean() {


    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    
}
