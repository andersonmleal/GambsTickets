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
        return calculaFaturamento(1);
    }

    public float getFatFevereiro() {
        return calculaFaturamento(2);
    }

    public float getFatMarço() {
        return calculaFaturamento(3);
    }

    public float getFatAbril() {
        return calculaFaturamento(4);
    }

    public float getFatMaio() {
        return calculaFaturamento(5);
    }

    public float getFatJunho() {
        return calculaFaturamento(6);
    }

    public float getFatJulho() {
        return calculaFaturamento(7);
    }

    public float getFatAgosto() {
        return calculaFaturamento(8);
    }

    public float getFatSetembro() {
        return calculaFaturamento(9);
    }

    public float getFatOutubro() {
        return calculaFaturamento(10);
    }

    public float getFatNovembro() {
        return calculaFaturamento(11);
    }

    public float getFatDezembro() {
        return calculaFaturamento(12);
    }

}
