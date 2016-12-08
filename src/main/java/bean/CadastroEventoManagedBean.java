/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import entidade.Setor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import jpa.EventoJPA;
import jpa.SetorJPA;

/**
 *
 * @author Anderson
 */
@Named(value = "cadastroEventoManagedBean")
@SessionScoped
public class CadastroEventoManagedBean implements Serializable {

    private Evento evento;
    private String mensagem;
    private String data;
    //setores
    private List<Setor> setores;
    private Setor removerSetor;
    private Setor setor;
    //private String nomeSetor;
    //private double precoSetor;
    //private int quantidadeTotal;
    // dados img backbround
    private Part imagemBack;
    private String nomeArquivoBack;
    // dados img principal  
    private Part imagem;
    private String nomeArquivo;
    private List<SelectItem> eventoSelect;
    private long idEvento;
    private Date dataCadastrada;

    public CadastroEventoManagedBean() {

        evento = new Evento();
        setor = new Setor();
        setores = new ArrayList<>();
    }

    public long getIdEvento() {

        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Setor getRemoverSetor() {
        return removerSetor;
    }

    public void setRemoverSetor(Setor removerSetor) {

        this.setores.remove(removerSetor);
        this.mensagem = "Setor removido";
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void salvarImagemBack() {
        nomeArquivoBack = obterNomeArquivoBack();
        if (nomeArquivoBack != null && nomeArquivoBack.trim().length() > 0) {
            salvarArquivoBack(nomeArquivoBack);
        }
    }

    private String obterNomeArquivoBack() {
        if (imagemBack != null) {
            String partHeader = imagemBack.getHeader("content-disposition");
            for (String content : partHeader.split(";")) {
                if (content.trim().startsWith("filename")) {
                    String nomeArquivo
                            = content.substring(content.indexOf('=') + 1)
                            .trim().replace("\"", "");
                    int lastFilePartIndex = nomeArquivo.lastIndexOf("\\");
                    if (lastFilePartIndex > 0) {
                        return nomeArquivo.substring(lastFilePartIndex,
                                nomeArquivo.length());
                    }
                    return nomeArquivo;
                }
            }
        }
        return null;
    }

    //C:\Users\Leal\Documents\PI\GambsTickets\src\main\webapp\img
    //C:\Users\anderson.mleal\Documents\NetBeansProjects\GambsTickets
    private void salvarArquivoBack(String nomeArquivo) {
        String diretorioDestino = "C:" + File.separator
                + "Users" + File.separator
                + "anderson.mleal" + File.separator
                + "Documents" + File.separator
                + "NetBeansProjects" + File.separator
                + "GambsTickets" + File.separator
                + "src" + File.separator
                + "main" + File.separator
                + "webapp" + File.separator
                + "img" + File.separator;
        File arquivo = new File(diretorioDestino + nomeArquivo);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = imagemBack.getInputStream();
            outputStream = new FileOutputStream(arquivo);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            //TODO: LOGAR ERRO
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
        }
    }

    public boolean isUploadRealizadoBack() {
        return (nomeArquivoBack != null && nomeArquivoBack.length() > 0);
    }

    public String getUrlImagemBack() {
        return "http://localhost:8080/img/" + nomeArquivoBack;
    }

    public Part getImagemBack() {
        return imagemBack;
    }

    public void setImagemBack(Part imagemBack) {
        this.imagemBack = imagemBack;
    }

    public String getNomeArquivoBack() {
        return nomeArquivoBack;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setNomeArquivoBack(String nomeArquivoBack) {
        this.nomeArquivoBack = nomeArquivoBack;
    }

    public void salvarImagem() {
        nomeArquivo = obterNomeArquivo();
        if (nomeArquivo != null && nomeArquivo.trim().length() > 0) {
            salvarArquivo(nomeArquivo);
        }
    }

    private String obterNomeArquivo() {
        if (imagem != null) {
            String partHeader = imagem.getHeader("content-disposition");
            for (String content : partHeader.split(";")) {
                if (content.trim().startsWith("filename")) {
                    String nomeArquivo
                            = content.substring(content.indexOf('=') + 1)
                            .trim().replace("\"", "");
                    int lastFilePartIndex = nomeArquivo.lastIndexOf("\\");
                    if (lastFilePartIndex > 0) {
                        return nomeArquivo.substring(lastFilePartIndex,
                                nomeArquivo.length());
                    }
                    return nomeArquivo;
                }
            }
        }
        return null;
    }

    //C:\Users\Leal\Documents\PI\GambsTickets\src\main\webapp\img
    private void salvarArquivo(String nomeArquivo) {
        String diretorioDestino = "C:" + File.separator
                + "Users" + File.separator
                + "anderson.mleal" + File.separator
                + "Documents" + File.separator
                + "NetBeansProjects" + File.separator
                + "GambsTickets" + File.separator
                + "src" + File.separator
                + "main" + File.separator
                + "webapp" + File.separator
                + "img" + File.separator;
        File arquivo = new File(diretorioDestino + nomeArquivo);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = imagem.getInputStream();
            outputStream = new FileOutputStream(arquivo);

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            //TODO: LOGAR ERRO
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    //TODO: LOGAR ERRO
                }
            }
        }
    }

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public boolean isUploadRealizado() {
        return (nomeArquivo != null && nomeArquivo.length() > 0);
    }

    public String getUrlImagem() {
        return "http://localhost:8080/img/" + nomeArquivo;
    }

    public String cadastrarEvento() {

        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            data = data.replace('-', '/');
            try {
                evento.setDt_evento(new java.sql.Date(format.parse(data).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            evento.setDt_cadastro_evento(c.getTime());
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            //Date data1 =(Date)sdf.parse(data);
            //c.setTime(data1);
            evento.setDt_evento(c.getTime());
            evento.setCaminhoImagem(obterNomeArquivo());
            evento.setCaminhoImagemBack(obterNomeArquivoBack());
            EventoJPA eventoJPA = new EventoJPA();
            eventoJPA.incluir(evento);
            // salva imagens no serividor
            salvarImagem();
            salvarImagemBack();
            // LOGICA DE SALVAR OS DADOS NO BANCO

            mensagem = "Evento cadastrado com Sucesso!";
        } catch (Exception e) {
            mensagem = "Ocorreu um erro, tente novamente.";
        }
        return "setoresCadastro.xhtml";

    }

    public void alterarEvento() {
        try {
            EventoJPA eventoJPA = new EventoJPA();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            data = data.replace('-', '/');
            try {
                evento.setDt_evento(new java.sql.Date(format.parse(data).getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            eventoJPA.alterar(evento);
            if (imagem != null) {
                salvarImagem();
            }
            if (imagemBack != null) {
                salvarImagemBack();
            }
            carregarEvento();
            mensagem = "Alterado com sucesso!";
        } catch (Exception e) {
            mensagem = "Erro: " + e;
        }
    }

    public String verificaSetores() {

        if (this.setores.isEmpty()) {
            return "true";
        } else {
            mensagem = "Não há setores cadastrados";
            return "false";
        }
    }

    public String cadastrarSetor() {
        try {
            Calendar c = Calendar.getInstance();
            SetorJPA setorJPA = new SetorJPA();
            setor.setDt_cadastro(c.getTime());
            setor.setQuantidadeDisponivel(setor.getQuantidade());
            setor.setId_evento(evento);
            setorJPA.incluir(setor);
            this.setores.add(setor);
            setor = new Setor();

            return "setoresCadastro.xhtml";
        } catch (Exception e) {

            mensagem = "Ocorreu um erro ao cadastrar Setor, tente novamente.";
            return "setoresCadastro.xhtml";
        }

    }

    public String destroy() {

        evento = null;
        mensagem = null;
        data = null;
        setores = null;
        removerSetor = null;
        setor = null;
        imagemBack = null;
        nomeArquivoBack = null;
        imagem = null;
        nomeArquivo = null;

        return "index.xhtml";
    }

    public List<Evento> listarEventos() {

        List<Evento> eventos = new ArrayList<>();

        EventoJPA eventoJPA = new EventoJPA();
        SetorJPA setorJPA = new SetorJPA();

        List<Evento> evs = eventoJPA.carregaEventos();
        List<Setor> setoress = setorJPA.carregaSetores();

        for (int i = 0; i < evs.size(); i++) {
            eventos.add(evs.get(i));

            for (Setor setore : setoress) {
                if (setore.getId_evento().getId_evento() == eventos.get(i).getId_evento()) {
                    eventos.get(i).addSetores(setore);
                }
            }

        }

        return eventos;
    }

    public String carregarEvento() {

        List<Evento> eventos;

        eventos = listarEventos();
        for (Evento evento1 : eventos) {
            if (evento1.getId_evento() == this.idEvento) {
                this.evento = evento1;
                this.setores = evento1.getSetores();

                SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                String date = formataData.format(evento1.getDt_evento());
                String d[] = date.split("/");
                String dateFormatado = d[1] + "-" + d[0] + "-" + d[2];
                this.data = dateFormatado;
                dataCadastrada = evento1.getDt_evento();
            }
        }

        return "alteraEvento.xhtml";
    }

    public Date getDataCadastrada() {
        return dataCadastrada;
    }

    public void setDataCadastrada(Date dataCadastrada) {
        this.dataCadastrada = dataCadastrada;
    }

}
