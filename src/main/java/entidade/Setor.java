/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author anderson.leal
 */
public class Setor {
    
    private String nomeSetor;
    private double preco;
    private int quantidade;
    private int quantidadeDisponivel;

    public Setor(String nomeSetor, double preco, int quantidade) {
        this.nomeSetor = nomeSetor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidade = quantidadeDisponivel;
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
    
    
}
