/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author anderson.leal
 */
@Entity
@Table(name = "Setor")
public class Setor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSetor;
    @ManyToOne
    private Evento id_evento;
    private String nomeSetor;
    private double preco;
    private int quantidade;
    private int quantidadeDisponivel;
    private int quantidadeSelecionada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_cadastro;
    private boolean status;

    public Setor(String nomeSetor, double preco, int quantidade) {
        this.nomeSetor = nomeSetor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidade = quantidadeDisponivel;
    }

    public Setor() {
    }

    public int getIdSetor() {
        return idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public int getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public void setQuantidadeSelecionada(int quantidadeSelecionada) {
        this.quantidadeSelecionada = quantidadeSelecionada;
    }

    public List<String> ingressos() {
        return null;

    }

    public Evento getId_evento() {
        return id_evento;
    }

    public void setId_evento(Evento id_evento) {
        this.id_evento = id_evento;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
