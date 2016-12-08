/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Relatorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

/**
 *
 * @author Leal
 */
@Named(value = "relatorioManagedBean")
@SessionScoped
public class RelatorioManagedBean implements Serializable {

    private String dataInicial;
    private String dataFinal;
    private String consulta;
    private String mensagem;

    public RelatorioManagedBean() {

    }

    public String gerarRelatorio() throws ServletException, ParseException {

        mensagem = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datInicial = (Date) format.parse(dataInicial);
        Date datFinal = (Date) format.parse(dataFinal);

        if (!datFinal.before(datInicial)) {
            switch (consulta) {
                case "vendas":
                    relatorioVenda(datInicial, datFinal);
                    break;
                case "eventos":
                    relatorioEvento(datInicial, datFinal);
                    break;
            }
            return "relatorios.xhtml";
        } else {
            mensagem = "Data inicial deve ser menor que data Final";
            return "relatorios.xhtml";
        }

    }

    public void relatorioVenda(Date datInicial, Date datFinal) throws ServletException, ParseException {

        try {

            Relatorio relatorio = new Relatorio();
            HSSFWorkbook wb = relatorio.relatorioVenda(datInicial, datFinal);

            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Vendas.xls\"");
            wb.write(externalContext.getResponseOutputStream());
            facesContext.responseComplete();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void relatorioEvento(Date datInicial, Date datFinal) {
        try {

            Relatorio relatorio = new Relatorio();
            HSSFWorkbook wb = relatorio.relatorioEvento(datInicial, datFinal);

            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();

            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.setResponseContentType("application/vnd.ms-excel");
            externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"Eventos.xls\"");
            wb.write(externalContext.getResponseOutputStream());
            facesContext.responseComplete();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

}
