/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Usuario;
import entidade.Venda;
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
public class VendaJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataTicket");

    public void incluir(Venda venda) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Venda> carregaVendas() {
        EntityManager em = emf.createEntityManager();
        try {
            // Query JPQL
            String className = Venda.class.getName();
            Query query = em.createQuery("select c from " + className + " c");

            return query.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Venda> buscaVendasCadastro(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            // Query JPQL
            Query query = em.createQuery("select v from Venda v where v.usuario = :cpf")
                    .setParameter("cpf", usuario);

            return query.getResultList();
        } finally {
            em.close();
        }

    }

}
