/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jpa.EventoJPA;
import jpa.VendaJPA;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author anderson.leal
 */
public class Relatorio {

    public HSSFWorkbook relatorioVenda(Date dtInicio, Date dtFim) {

        //cria planilha
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet firstSheet = workbook.createSheet("VENDAS");

        try {

            //Formatando a fonte
            HSSFFont fonte = workbook.createFont();
            fonte.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle estilo = workbook.createCellStyle();
            estilo.setFillBackgroundColor(HSSFColor.BLACK.index);
            estilo.setFont(fonte);
            HSSFRow row = firstSheet.createRow(0);

            // lista para criar cabecalho
            String[] cabecalho = {"ID VENDA", "DATA CADASTRO", "QUANTIDADE", "VALOR"};

            // popula cabecalho
            for (int i = 0; i < cabecalho.length; i++) {

                firstSheet.setColumnWidth((short) (i), (short) (4600));
                Cell cell = row.createCell(i);
                cell.setCellStyle(estilo);
                cell.setCellValue(cabecalho[i]);

            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Venda> lista = new ArrayList<>();

            VendaJPA venda = new VendaJPA();
            lista = venda.carregaVendas();

            int i = 1;

            for (Venda pro : lista) {

                // se data da venda estiver antes da data fim e depois da data inicio
                if (pro.getDt_cadastro().before(dtFim) && pro.getDt_cadastro().after(dtInicio)) {

                    // nova linha na planilha
                    row = firstSheet.createRow(i);
                    // altera data para string
                    String data = sdf.format(pro.getDt_cadastro());

                    row.createCell(0).setCellValue(pro.getId_venda());
                    row.createCell(1).setCellValue(data);
                    row.createCell(2).setCellValue(pro.getQuantidade());
                    row.createCell(3).setCellValue(pro.getValor());

                    i++;
                }

            } // fim do for

            firstSheet.setAutoFilter(CellRangeAddress.valueOf("A1:D" + i));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar arquivo");
            System.out.println(e);
        }

        return workbook;
    }

    public HSSFWorkbook relatorioEvento(Date dtInicio, Date dtFim) {

        //cria planilha
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet firstSheet = workbook.createSheet("EVENTOS");

        try {

            //Formatando a fonte
            HSSFFont fonte = workbook.createFont();
            fonte.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle estilo = workbook.createCellStyle();
            estilo.setFillBackgroundColor(HSSFColor.BLACK.index);
            estilo.setFont(fonte);
            HSSFRow row = firstSheet.createRow(0);

            // lista para criar cabecalho
            String[] cabecalho = {"ID EVENTO", "NOME EVENTO", "LOCAL", "HORÁRIO", "DATA",
                "DESCRIÇÃO", "IMAGEM PRINCIPAL", "IMAGEM BACKGROUND", "DATA ALTUALIZAÇÃO"};

            // popula cabecalho
            for (int i = 0; i < cabecalho.length; i++) {

                firstSheet.setColumnWidth((short) (i), (short) (4600));
                Cell cell = row.createCell(i);
                cell.setCellStyle(estilo);
                cell.setCellValue(cabecalho[i]);

            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Evento> lista = new ArrayList<>();

            EventoJPA evento = new EventoJPA();
            lista = evento.carregaEventos();

            int i = 1;

            for (Evento pro : lista) {

                // se data do Evento estiver antes da data fim e depois da data inicio
                if (pro.getDt_evento().before(dtFim) && pro.getDt_evento().after(dtInicio)) {
                    // nova linha na planilha
                    row = firstSheet.createRow(i);
                    // altera data para string
                    String dataCadastro = sdf.format(pro.getDt_cadastro_evento());
                    String dataEvento = sdf.format(pro.getDt_evento());

                    row.createCell(0).setCellValue(pro.getId_evento());
                    row.createCell(1).setCellValue(pro.getNome_evento());
                    row.createCell(2).setCellValue(pro.getLocal_evento());
                    row.createCell(3).setCellValue(pro.getHoraEvento());
                    row.createCell(4).setCellValue(dataEvento);
                    row.createCell(5).setCellValue(pro.getDescricao());
                    row.createCell(6).setCellValue(pro.getCaminhoImagem());
                    row.createCell(7).setCellValue(pro.getCaminhoImagemBack());
                    row.createCell(8).setCellValue(dataCadastro);

                    i++;
                }

            } // fim do for

            firstSheet.setAutoFilter(CellRangeAddress.valueOf("A1:I" + i));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar arquivo");
            System.out.println(e);
        }

        return workbook;
    }

}
