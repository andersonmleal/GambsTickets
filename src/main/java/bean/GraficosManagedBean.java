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

    float fatJaneiro;
    float fatFevereiro;
    float fatMarço;
    float fatAbril;
    float fatMaio;
    float fatJunho;
    float fatJulho;
    float fatAgosto;
    float fatSetembro;
    float fatOutubro;
    float fatNovembro;
    float fatDezembro;

    public GraficosManagedBean() {
    }
    //0, 5000, 5000, 8000, 8000, 7000, 8000, 9000, 8000, 11000, 13000, 13000, 12000, 14000, 15000, 15000, 17000, 18000, , , 

    public Object getFatJaneiro() {
        fatJaneiro = 1;
        if(fatJaneiro == 0){
            return null;
        }
        return (float)fatJaneiro;
    }

    public Object getFatFevereiro() {
        fatFevereiro = 5000;
         if(fatFevereiro == 0){
            return null;
        }
        return (float)fatFevereiro;
    }

    public Object getFatMarço() {
        fatMarço = 5000;
         if(fatMarço == 0){
            return null;
        }
        return (float)fatMarço;
    }

    public Object getFatAbril() {
        fatAbril = 8000;
         if(fatAbril == 0){
            return null;
        }
        return (float)fatAbril;
    }

    public Object getFatMaio() {
        fatMaio = 8000;
         if(fatMaio == 0){
            return null;
        }
        return (float)fatMaio;
    }

    public Object getFatJunho() {
        fatJunho = 7000;
         if(fatJunho == 0){
            return null;
        }
        return (float)fatJunho;
    }

    public Object getFatJulho() {
        fatJulho = 8000;
         if(fatJulho == 0){
            return null;
        }
        return (float)fatJulho;
    }

    public Object getFatAgosto() {
        fatAgosto = 9000;
         if(fatAgosto == 0){
            return null;
        }
        return (float)fatAgosto;
    }

    public Object getFatSetembro() {
        fatSetembro = 11000;
         if(fatSetembro == 0){
            return null;
        }
        return (float)fatSetembro;
    }

    public Object getFatOutubro() {
        fatOutubro = 10000;
         if(fatOutubro == 0){
            return null;
        }
        return (float)fatOutubro;
    }

    public Object getFatNovembro() {
        fatNovembro = 8000;
         if(fatNovembro == 0){
            return null;
        }
        return (float)fatNovembro;
    }

    public Object getFatDezembro() {
        fatDezembro = 0;
         if(fatDezembro == 0){
            return null;
        }
        return (float)fatDezembro;
    }

}
