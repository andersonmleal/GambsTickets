/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Usuario;
import entidade.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import jpa.VendaJPA;

/**
 *
 * @author gustavo.oliveira
 */
@Named(value = "comprasManagedBean")
@ViewScoped
public class ComprasManagedBean {

    private List<Venda> vendas;

    public ComprasManagedBean() {

        vendas = new ArrayList<>();

    }

    public List<Venda> recuperaVenda() {

        VendaJPA banco = new VendaJPA();

        LoginBean login = new LoginBean();
        Usuario user = login.recuperaUsuario();
        long cpf = user.getCpf();

        return banco.buscaVendasCadastro(cpf);
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
