    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class UsuarioDAO {

    private Session sessao;
    private Transaction trans;

    public void addUsuario(Usuario user) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Usuario usuario = new Usuario();
            usuario.setCpf(user.getCpf());
            usuario.setNome(user.getNome());
            usuario.setSobreNome(user.getSobreNome());
            usuario.setEmail(user.getEmail());
            usuario.setSenha(user.getSenha());
            usuario.setSexo(user.getSexo());
            usuario.setRg(user.getRg());
            usuario.setNacionalidade(user.getNacionalidade());
            usuario.setTipo_usuario(user.getTipo_usuario());
            usuario.setStatus(user.getStatus());
            usuario.setDtCadastro(user.getDtCadastro());

            sessao.save(usuario);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Usuario user) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(user);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
