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
 * @author Anderson
 */
@Named(value = "cadastroEventoManagedBean")
@SessionScoped
public class CadastroEventoManagedBean implements Serializable {

    
    private Evento evento;
    
    public CadastroEventoManagedBean() {
        
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    
}
