    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Evento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Conexao;

/**
 *
 * @author guilherme.gsilv10
 */
public class EventoDAO {

    private Session sessao;
    private Transaction trans;

    public void addEndereco(Evento event) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Evento evento = new Evento();
            evento.setId_evento(event.getId_evento());
            evento.setNome_evento(event.getNome_evento());
            evento.setLocal_evento(event.getLocal_evento());
            evento.setDt_evento(event.getDt_evento());
            evento.setDt_cadastro_evento(event.getDt_cadastro_evento());
            evento.setStatus(event.isStatus());

            sessao.save(evento);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    public void removeUsuario(Evento evento) {
        try {
            sessao = Conexao.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(evento);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
