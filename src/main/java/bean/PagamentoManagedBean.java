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

    public PagamentoManagedBean() {

    }

    public FormaPagamento getPagamento() {
        pagamento = new FormaPagamento(numCartao, nomePro.toUpperCase(), codVerificador, mesCartao, anoCartao);
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
        return numCartao;
    }

    public String getNomePro() {
        return nomePro;
    }

    public long getCodVerificador() {
        return codVerificador;
    }
 

}
