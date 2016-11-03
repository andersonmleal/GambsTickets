    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Endereco;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class EnderecoDAO {

    private Session sessao;
    private Transaction trans;

    public void addEndereco(Endereco end) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Endereco endereco = new Endereco();
            endereco.setLogradouro(end.getLogradouro());
            endereco.setNumero(end.getNumero());
            endereco.setComplemento(end.getComplemento());
            endereco.setBairro(end.getBairro());
            endereco.setCidade(end.getCidade());
            endereco.setEstado(end.getEstado());
            endereco.setCep(end.getCep());
            endereco.setUsuario_evento(end.getUsuario_evento());
            endereco.setDt_cadastro(end.getDt_cadastro());
            endereco.setStatus(end.isStatus());

            sessao.save(endereco);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Endereco endereco) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(endereco);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
