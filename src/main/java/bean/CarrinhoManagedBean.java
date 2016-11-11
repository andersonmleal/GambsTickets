/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import entidade.EventoIngressos;
import entidade.Setor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leal
 */
@Named(value = "CarrinhoManagedBean")
@SessionScoped
public class CarrinhoManagedBean implements Serializable {

    private List<EventoIngressos> eventos;
    private String etapaCompra;

    public CarrinhoManagedBean() {

        eventos = new ArrayList<>();

    }

    public List<EventoIngressos> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoIngressos> eventos) {
        this.eventos = eventos;
    }

    
    
    public boolean addCarrinho(EventoIngressos ev) {

        try {
            eventos.add(ev);
            return true;
        } catch (Exception e) {

            return false;
        }

    }

    public int getTamanhoArray() {
        return eventos.size();
    }

    public String getEtapaCompra() {
        if (etapaCompra == null) {
            etapaCompra = "etapaCompra-itensCarrinho.xhtml";
        }
        return etapaCompra;
    }

    public void setEtapaCompra(String etapaCompra) {
        this.etapaCompra = etapaCompra;
    }

    public void proximaEtapa(int etapaAtual) {
        switch (etapaAtual) {
            case 1:
                etapaCompra = "etapaCompra-enderecoEntrega.xhtml";
                break;

            case 2:
                etapaCompra = "etapaCompra-formaPagamento.xhtml";
                break;

            case 3:
                etapaCompra = "etapaCompra-resumoCompra.xhtml";
                break;

        }
    }

    public void voltarEtapa(int etapaAtual) {
        switch (etapaAtual) {
            case 2:
                etapaCompra = "etapaCompra-itensCarrinho.xhtml";
                break;

            case 3:
                etapaCompra = "etapaCompra-enderecoEntrega.xhtml";
                break;

            case 4:
                etapaCompra = "etapaCompra-formaPagamento.xhtml";
                break;

        }
    }

}
