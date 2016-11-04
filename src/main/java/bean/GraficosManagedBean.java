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

    float fatJaneiro = 1000;
    float fatFevereiro = 5000;
    float fatMarço = 5000;
    float fatAbril = 8000;
    float fatMaio = 8000;
    float fatJunho = 7000;
    float fatJulho = 9000;
    float fatAgosto = 11000;
    float fatSetembro = 13000;
    float fatOutubro = 12000;
    float fatNovembro = 14000;
    float fatDezembro;

    public GraficosManagedBean() {
    }
    //0, 5000, 5000, 8000, 8000, 7000, 8000, 9000, 8000, 11000, 13000, 13000, 12000, 14000, 15000, 15000, 17000, 18000, , , 

    public float getFatJaneiro() {
        return fatJaneiro;
    }

    public float getFatFevereiro() {
        return fatFevereiro;
    }

    public float getFatMarço() {
        return fatMarço;
    }

    public float getFatAbril() {
        return fatAbril;
    }

    public float getFatMaio() {
        return fatMaio;
    }

    public float getFatJunho() {
        return fatJunho;
    }

    public float getFatJulho() {
        return fatJulho;
    }

    public float getFatAgosto() {
        return fatAgosto;
    }

    public float getFatSetembro() {
        return fatSetembro;
    }

    public float getFatOutubro() {
        return fatOutubro;
    }

    public float getFatNovembro() {
        return fatNovembro;
    }

    public float getFatDezembro() {
        return fatDezembro;
    }

  
}
