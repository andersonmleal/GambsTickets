/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Endereco;
import entidade.FormaPagamento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author silvana
 */
public class FormaPagamentoJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataTicket");

    public void incluir(FormaPagamento formaPagamento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(formaPagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<FormaPagamento> verificaCadastro(long formaPagamento) {
        EntityManager em = emf.createEntityManager();
        try {
            // Query JPQL
            Query query = em.createQuery("select fp from FormaPagamento fp where fp.id_formaP = :fPgto")
                    .setParameter("fPgto", formaPagamento);

            return query.getResultList();
        } finally {
            em.close();
        }

    }
}
