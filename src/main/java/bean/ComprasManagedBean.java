/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Usuario;
import entidade.Venda;
import jpa.VendaJPA;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo.oliveira
 */
@Named(value = "comprasManagedBean")
@SessionScoped
public class ComprasManagedBean implements Serializable {

    private List<Venda> vendas;
    

    public ComprasManagedBean() {

        vendas = new ArrayList<>();

    }

    public void recuperaVenda() {

        VendaJPA banco = new VendaJPA();

        LoginBean login = new LoginBean();
        Usuario user = login.recuperaUsuario();
        long cpf = user.getCpf();

        vendas = banco.buscaVendasCadastro(user);
    }

    public List<Venda> getVendas() {
        recuperaVenda();
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
