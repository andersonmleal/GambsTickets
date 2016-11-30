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

    float fatJaneiro = calculaFaturamento(1);
    float fatFevereiro = calculaFaturamento(2);
    float fatMarço = calculaFaturamento(3);
    float fatAbril = calculaFaturamento(4);
    float fatMaio = calculaFaturamento(5);
    float fatJunho = calculaFaturamento(6);
    float fatJulho  = calculaFaturamento(7);
    float fatAgosto = calculaFaturamento(8);
    float fatSetembro = calculaFaturamento(9);
    float fatOutubro = calculaFaturamento(10);
    float fatNovembro  = calculaFaturamento(11);
    float fatDezembro = calculaFaturamento(12);

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
