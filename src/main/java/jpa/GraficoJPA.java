/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class GraficoJPA {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataTicket");
    EntityManager em = emf.createEntityManager();

    public GraficoJPA() {

    }

    public float faturamento(int mes, int ano) {
        //Monta query da consulta
        String query = "SELECT sum(QUANTIDADE) FROM APP.VENDA WHERE DT_CADASTRO between '2016-11-01' and '2016-11-31';";
        Query qr = em.createQuery(query);
       
        return (float) qr.getSingleResult();
    }

}
