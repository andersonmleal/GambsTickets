    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class VendaDAO {

    private Session sessao;
    private Transaction trans;

    public void addEndereco(Venda vend) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Venda venda = new Venda();
            venda.setId_venda(vend.getId_venda());
            venda.setId_tipo_setor(vend.getId_tipo_setor());
            venda.setUsuario(vend.getUsuario());
            venda.setQuantidade(vend.getQuantidade());
            venda.setDt_cadastro(vend.getDt_cadastro());
            venda.setStatus(vend.isStatus());

            sessao.save(venda);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Venda venda) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(venda);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
