/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson.mleal
 */
public class EventoIngressos{

    private Setor setor;
    private List<Setor> setores = new ArrayList<>();
    private Evento evento;
    private int quantidadeSelecionada;
    private double precoUnitario;
    private double precoTotal;

    public EventoIngressos() {
        this.quantidadeSelecionada = 0;
    }

    public EventoIngressos(Setor setor, Evento evento, int quantidadeSelecionada) {
        
        this.setor = setor;
        this.evento = evento;
        this.quantidadeSelecionada = quantidadeSelecionada;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    public int getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public double getPrecoTotal() {
        precoTotal = quantidadeSelecionada * precoUnitario;
        return precoTotal;
    }
    
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    

    public EventoIngressos(Setor setor) {
        this.setor = setor;

        for (int i = 1; i < 7; i++) {

            Setor set = new Setor(setor.getNomeSetor(), setor.getPreco(), setor.getQuantidade());
            set.setQuantidadeSelecionada(i);
            setores.add(set);

        }

    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

}
