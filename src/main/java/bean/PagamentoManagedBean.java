/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.FormaPagamento;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Anderson
 */
@Named(value = "pagamentoManagedBean")
@SessionScoped
public class PagamentoManagedBean implements Serializable {

    private FormaPagamento pagamento;
    private int mesCartao;
    private int anoCartao;
    private String numCartao;
    private String nomePro;
    private long codVerificador;
    //combo cartao
    private String comb1;
    private String comb2;
    private String comb3;
    private String comb4;

    public PagamentoManagedBean() {

    }

    public FormaPagamento getPagamento() {
        pagamento = new FormaPagamento(getNumCartao(), nomePro, codVerificador, mesCartao, anoCartao);
            return pagamento;
    }

    public int getMesCartao() {
        return mesCartao;
    }

    public void setMesCartao(int mesCartao) {
        this.mesCartao = mesCartao;
        //this.pagamento.setMesValidade(mesCartao);
    }

    public int getAnoCartao() {
        return anoCartao;
    }

    public void setAnoCartao(int anoCartao) {
        this.anoCartao = anoCartao;
        //this.pagamento.setAnoValidade(anoCartao);
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public void setCodVerificador(long codVerificador) {
        this.codVerificador = codVerificador;
    }

    public String getNumCartao() {
        this.numCartao = comb1 + comb2 + comb3 +comb4;
        return numCartao;
    }

    public String getNomePro() {
        return nomePro;
    }

    public long getCodVerificador() {
        return codVerificador;
    }

    public String getComb1() {
        return comb1;
    }

    public void setComb1(String comb1) {
        this.comb1 = comb1;
    }

    public String getComb2() {
        return comb2;
    }

    public void setComb2(String comb2) {
        this.comb2 = comb2;
    }

    public String getComb3() {
        return comb3;
    }

    public void setComb3(String comb3) {
        this.comb3 = comb3;
    }

    public String getComb4() {
        return comb4;
    }

    public void setComb4(String comb4) {
        this.comb4 = comb4;
    }


    
    
    

}
