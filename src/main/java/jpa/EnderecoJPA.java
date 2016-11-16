/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Endereco;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author silvana
 */
public class EnderecoJPA {

    private EntityManagerFactory emFactory
            = Persistence.createEntityManagerFactory("DataTicket");


    public void incluir(Endereco endereco) {
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction transacao = em.getTransaction();
        try {
            transacao.begin();
            em.persist(endereco);
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
        } finally {
            em.close();
        }
    }

}
