/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
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
@Named(value = "detalheManagedBean")
@SessionScoped
public class DetalheManagedBean implements Serializable {

    /**
     * Creates a new instance of DetalheManagedBean
     */
    private Evento evento;
    private List<Setor> setores;
    private List<Setor> ingressoInt;
    private List<Setor> ingressoMeia;

    private List<String> ingressoIntSelecionado;
    private ArrayList<String> ingressoMeiaSelecionado;
    private String inteira;
    private String meia;

    public DetalheManagedBean() {

        ingressoInt = new ArrayList<>();
        ingressoMeia = new ArrayList<>();
        ingressoIntSelecionado = new ArrayList<>();
        ingressoMeiaSelecionado = new ArrayList<>();
    }

    public List<Setor> getIngressoInt(int id) {

        for (int i = 0; i < 5; i++) {

            Setor set = new Setor(
                    id,
                    evento.getSetores().get(id).getNomeSetor(),
                    evento.getSetores().get(id).getPreco(),
                    evento.getSetores().get(id).getQuantidade());
            set.setQuantidadeSelecionada(String.valueOf(i));

            ingressoInt.add(set);
        }

        return ingressoInt;
    }

    public List<Setor> getIngressoMeia() {
        return ingressoMeia;
    }

    public String getInteira() {
        return inteira;
    }

    public void setInteira(String inteira) {
        this.inteira = inteira;
        this.ingressoIntSelecionado.add(inteira);
    }

    public String getMeia() {
        return meia;
    }

    public void setMeia(String meia) {
        this.meia = meia;
        this.ingressoMeiaSelecionado.add(meia);
    }

    public List<String> getIngressoIntSelecionado() {
        return ingressoIntSelecionado;
    }

    public List<String> getIngressoMeiaSelecionado() {
        return ingressoMeiaSelecionado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
