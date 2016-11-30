/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public GraficoJPA() {

    }

    public float faturamento(int mes, int ano) throws ParseException {
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dtInicial = "01/11/2016";
        String dtFinal = "30/11/2016";
        //CONVERTE STRING NO FORMATO dd/MM/yyyy PARA SQL DATA.
        java.sql.Date dataIni = new java.sql.Date(format.parse(dtInicial).getTime());
        java.sql.Date dataFin = new java.sql.Date(format.parse(dtFinal).getTime());
        try {
            // Query JPQL
            Query query = em.createQuery("select sum(v.quantidade) from Venda v WHERE v.dt_cadastro >= :dataInicial and v.dt_cadastro <= :dataFinal");
            query.setParameter("dataInicial", dataIni);
            query.setParameter("dataFinal", dataFin);
            float resultado = (float) query.getSingleResult();
            return resultado;
        } finally {
            em.close();
        }
    }

}
