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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;

/**
 *
 * @author Leal
 */
@Named(value = "relatorioManagedBean")
@SessionScoped
public class RelatorioManagedBean implements Serializable {

    private Date dataInicial;
    private Date dataFinal;

    public RelatorioManagedBean() {

    }

    public void relatorioVenda() throws ServletException {
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        String dtInicial = request.getParameter("pInicial");
        String dtFinal = request.getParameter("pFinal");

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            dataInicial = (Date) formatter.parse(dtInicial);
            dataFinal = (Date) formatter.parse(dtFinal);
            Relatorio relatorio = new Relatorio();
            HSSFWorkbook wb = relatorio.relatorioVenda(null, null);

            ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/ms-excel");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0");
            response.setHeader("Content-Disposition", "attachment; filename=vendas.xls");
            OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
        } catch (Exception ex) {
        }
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

}
