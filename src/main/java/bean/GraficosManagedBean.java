/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author gustavo.oliveira
 */
@Named(value = "GraficosManagedBean")
@RequestScoped
public class GraficosManagedBean {

    /**
     * Creates a new instance of GraficosManagedBean
     */
    public GraficosManagedBean() {
    }
    
}
