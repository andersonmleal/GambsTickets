/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson.mleal
 */
public class EventoIngressos {

    private Setor setor;
    private int inteira;
    private int meia;
    private List<Setor> setores = new ArrayList<>();

    public EventoIngressos() {
    }

    public EventoIngressos(Setor setor) {
        this.setor = setor;

        for (int i = 1; i < 7; i++) {

            Setor set = new Setor(setor.getIdSetor(), setor.getNomeSetor(), setor.getPreco(), setor.getQuantidade());
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
