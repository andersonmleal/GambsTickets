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
    private String logradouro;
    private int numero;
    private String complemento;
    private String cidade;
    private String bairro;
    private String estado;
    private long cep;

    public EnderecoManagedBean() {
        

    }

    public Endereco getEndereco() {
        endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
        return endereco;
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

    
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        endereco.setLogradouro(logradouro);
    }

    public void setNumero(int numero) {
        this.numero = numero;
        endereco.setNumero(numero);
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
        endereco.setComplemento(complemento);
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        endereco.setCidade(cidade);
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
        endereco.setBairro(bairro);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        endereco.setEstado(estado);
    }

    public void setCep(long cep) {
        this.cep = cep;
        endereco.setCep(cep);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public long getCep() {
        return cep;
    }
    
    
    

}
