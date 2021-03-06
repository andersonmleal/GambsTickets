/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Usuario;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author silvana
 */
public class UsuarioJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataTicket");

    public void incluir(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(usuario);
            et.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Usuario> verificaCadastro(long usuario) {
        EntityManager em = emf.createEntityManager();
        try {
            // Query JPQL
            Query query = em.createQuery("select usuario from Usuario usuario where usuario.cpf = :cpf")
                    .setParameter("cpf", usuario);

                       return query.getResultList();
        } finally {
            em.close();
        }

    }
   
  

    public void alterar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(usuario);
            et.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
