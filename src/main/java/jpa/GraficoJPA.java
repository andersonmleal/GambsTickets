/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entidade.Venda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public float faturamento(int mes, int ano) {
        float resultado = 0;
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //DATAS HARDCODE
        String dtInicial = "01/" + mes + "/" + ano + "";
        String dtFinal = "31/" + mes + "/" + ano + "";
        //CONVERTE STRING NO FORMATO dd/MM/yyyy PARA SQL DATA.
        java.sql.Date dataIni = null;
        java.sql.Date dataFin = null;
        try {
            dataIni = new java.sql.Date(format.parse(dtInicial).getTime());
            dataFin = new java.sql.Date(format.parse(dtFinal).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(GraficoJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Query JPQL
            Query query = em.createQuery("select v from Venda v WHERE v.dt_cadastro >= :dataInicial and v.dt_cadastro <= :dataFinal");
            query.setParameter("dataInicial", dataIni);
            query.setParameter("dataFinal", dataFin);

            List<Venda> vendas = query.getResultList();
            //SOMA O RESULTADO PERCORRENDO JÁ QUE O SUM DANDO ERRADO.
            if (vendas.size() > 0) {
                for (int i = 0; i < query.getResultList().size(); i++) {
                    resultado = (float) (resultado + vendas.get(i).getValor());
                    System.out.println(resultado);
                }
            }
            return resultado;
        } finally {
            em.close();
        }
    }

}
