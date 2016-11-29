/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import jpa.GraficoJPA;

/**
 *
 * @author gustavo.oliveira
 */
@Named(value = "GraficosManagedBean")
@RequestScoped
public class GraficosManagedBean {

    float fatJaneiro;
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
        this.fatJaneiro = calculaFaturamento(1);
        this.fatFevereiro = calculaFaturamento(2);
        this.fatMarço = calculaFaturamento(3);
        this.fatAbril = calculaFaturamento(4);
        this.fatMaio = calculaFaturamento(5);
        this.fatJunho = calculaFaturamento(6);
        this.fatJulho = calculaFaturamento(7);
        this.fatAgosto = calculaFaturamento(8);
        this.fatSetembro = calculaFaturamento(9);
        this.fatOutubro = calculaFaturamento(10);
        this.fatNovembro = calculaFaturamento(11);
        this.fatDezembro = calculaFaturamento(12);
        
    }
    
    public float calculaFaturamento(int mes) {
        Calendar c = Calendar.getInstance();
        GraficoJPA jpa = new GraficoJPA();
        //captura ano atual do relatorio
        int ano = c.get(c.YEAR);
        //busca no banco o total do mes
        float fat = jpa.faturamento(mes, ano);
        return fat;
    }

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
