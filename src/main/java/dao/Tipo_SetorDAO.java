    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Tipo_Setor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class Tipo_SetorDAO {

    private Session sessao;
    private Transaction trans;

    public void addEndereco(Tipo_Setor typeSet) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Tipo_Setor tipo_setor = new Tipo_Setor();
            tipo_setor.setId_tipo_setor(typeSet.getId_tipo_setor());
            tipo_setor.setId_evento(typeSet.getId_evento());
            tipo_setor.setNome_setor(typeSet.getNome_setor());
            tipo_setor.setCapacidade(typeSet.getCapacidade());
            tipo_setor.setVendidos(typeSet.getVendidos());
            tipo_setor.setPreco(typeSet.getPreco());
            tipo_setor.setDt_cadastro(typeSet.getDt_cadastro());
            tipo_setor.setStatus(typeSet.isStatus());

            sessao.save(tipo_setor);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Tipo_Setor tipo_setor) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(tipo_setor);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
