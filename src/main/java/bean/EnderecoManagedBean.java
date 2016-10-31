/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EnderecoDAO;
import dao.EventoDAO;
import entidade.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author silvana
 */
@ManagedBean
@Named(value = "enderecoManagedBean")
@RequestScoped
public class EnderecoManagedBean {
    
    private Endereco endereco;
    private EnderecoDAO enderecoDAO;

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
        enderecoDAO.addEndereco(endereco);
        return "menu";
    }
}
