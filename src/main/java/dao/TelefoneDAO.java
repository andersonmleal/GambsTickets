    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Telefone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class TelefoneDAO {

    private Session sessao;
    private Transaction trans;

    public void addEndereco(Telefone telef) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Telefone telefone = new Telefone();
            telefone.setId_telefone(telef.getId_telefone());
            telefone.setDescricao(telef.getDescricao());
            telefone.setUsuario_evento(telef.getUsuario_evento());
            telefone.setDt_cadastro(telef.getDt_cadastro());
            telefone.setStatus(telef.isStatus());

            sessao.save(telefone);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Telefone telefone) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(telefone);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
