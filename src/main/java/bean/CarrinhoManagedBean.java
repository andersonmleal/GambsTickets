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
    private String mensagem;
    private EventoIngressos removerItem;

    public CarrinhoManagedBean() {

        eventos = new ArrayList<>();

    }

    public EventoIngressos getRemoverItem() {
        return removerItem;
    }

    public void setRemoverItem(EventoIngressos removerItem) {
        this.eventos.remove(removerItem);
        this.mensagem = "Ingressos removidos";
    }

    public List<EventoIngressos> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoIngressos> eventos) {

        this.mensagem = "";
        int cont;

        for (int i = 0; i < eventos.size(); i++) {
            cont = 0;

            for (int j = 0; j < this.eventos.size(); j++) {
                if (//verifica se ja existe ingressos com mesmo nome de evento
                        eventos.get(i).getEvento().getNome_evento().equals(this.eventos.get(j).getEvento().getNome_evento())
                        //verifica se ja existe ingressos com mesmo nome de setor
                        && eventos.get(i).getSetor().getNomeSetor().equals(this.eventos.get(j).getSetor().getNomeSetor())
                        //verifica se ja existe ingressos com mesmo preco
                        && eventos.get(i).getPrecoUnitario() == this.eventos.get(j).getPrecoUnitario()) {

                    cont++;
                    this.mensagem = "Já existem ingresso selecionados para um dos setores. Os mesmos não foram adicionados.";
                }
            }
            if (cont == 0) {
                this.eventos.add(eventos.get(i));
            }
        }

    }

    public String getMensagem() {
        return mensagem;
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

    public String verificaIngressos() {

        if (this.eventos.isEmpty()) {
            return "true";
        } else {
            return "false";
        }
    }

    public String verificaIngressosMensagem() {

        if (this.eventos.isEmpty()) {
            return "O carrinho está vazio. Adicione ingressos para prosseguir.";
        } else {
            return "";
        }
    }

    public Object retornaClasse() throws CloneNotSupportedException {
        return this.clone();
    }

}
