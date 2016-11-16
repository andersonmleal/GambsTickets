/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FormaPagamento")
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_formaP;
    @OneToOne(mappedBy = "formaPagamento")
    private Venda id_venda;
    private String bandeira;
    private int parcela;
    private long numCartao;
    private String nomePro;
    private long codVerificador;
    private String validade;
    private double juros;
    private int mesValidade;
    private int anoValidade;

    public FormaPagamento() {
    }

    public FormaPagamento(String numCartao, String nomePro, long codVerificador, int mesValidade, int anoValidade) {
        this.numCartao = Long.parseLong(numCartao);
        this.nomePro = nomePro;
        this.codVerificador = codVerificador;
        this.mesValidade = mesValidade;
        this.anoValidade = anoValidade;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    
    
    
    public int getMesValidade() {
        return mesValidade;
    }


    public void setMesValidade(int mesValidade) {
        this.mesValidade = mesValidade;
    }

    public int getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade) {
        this.anoValidade = anoValidade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public long getId_formaP() {
        return id_formaP;
    }

    public void setId_formaP(long id_formaP) {
        this.id_formaP = id_formaP;
    }

    public Venda getId_venda() {
        return id_venda;
    }

    public void setId_venda(Venda id_venda) {
        this.id_venda = id_venda;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public long getNumCartao() {
        return numCartao;
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }

    public long getCodVerificador() {
        return codVerificador;
    }

    public void setCodVerificador(long codVerificador) {
        this.codVerificador = codVerificador;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

}
