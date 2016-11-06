/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import jpa.EnderecoJPA;

/**
 *
 * @author silvana
 */
@ManagedBean
@Named(value = "enderecoManagedBean")
@RequestScoped
public class EnderecoManagedBean {
    
    private Endereco endereco;
    private EnderecoJPA enderecoJPA;
    
    public EnderecoManagedBean() {
        endereco = new Endereco();

    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String cadastrar() {
        Calendar c = Calendar.getInstance();
        endereco.setDt_cadastro(c.getTime());

        enderecoJPA = new EnderecoJPA();
        enderecoJPA.incluir(endereco);
        return "menu";
    }
}
