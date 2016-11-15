/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Endereco;
import entidade.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.EnderecoJPA;

/**
 *
 * @author silvana
 */
@ManagedBean
@Named(value = "endereco")
@SessionScoped
public class EnderecoManagedBean implements Serializable {

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

    public void cadastrar(Usuario user) {
        Calendar c = Calendar.getInstance();
        endereco.setDt_cadastro(c.getTime());
        endereco.setUsuario_evento(user);

        enderecoJPA = new EnderecoJPA();
        enderecoJPA.incluir(endereco);

    }

    public EnderecoJPA getEnderecoJPA() {
        return enderecoJPA;
    }

    public void setEnderecoJPA(EnderecoJPA enderecoJPA) {
        this.enderecoJPA = enderecoJPA;
    }

   }
