/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author anderson.leal
 */
public class Setor {
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

    public Setor(int id, String nomeSetor, double preco, int quantidade) {
        this.nomeSetor = nomeSetor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidade = quantidadeDisponivel;
        this.idSetor = id;
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

    
    
    public List<String> ingressos(){
        return null;
    
    
    }

}
