/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Endereco;
import entidade.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

        public List<Endereco> verificaCadastro(long end) {
        EntityManager em = emFactory.createEntityManager();
        try {
            // Query JPQL
            Query query = em.createQuery("select ender from Endereco ender where ender.id_endereco = :end")
                    .setParameter("end", end);

                       return query.getResultList();
        } finally {
            em.close();
        }

    }
    
}
