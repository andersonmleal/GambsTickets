/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Evento;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.Part;

/**
 *
 * @author Anderson
 */
@Named(value = "cadastroEventoManagedBean")
@SessionScoped
public class CadastroEventoManagedBean implements Serializable {

    private Evento evento;
    // dados img backbround
    private Part imagemBack;
    private String nomeArquivoBack;
    // dados img principal  
    private Part imagem;
    private String nomeArquivo;

    public CadastroEventoManagedBean() {

        evento = new Evento();
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

    private void salvarArquivoBack(String nomeArquivo) {
        String diretorioDestino = "C:" + File.separator + "desenv"
                + File.separator + "imagens" + File.separator;
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
        return "http://localhost:8080/imagens/" + nomeArquivoBack;
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

    private void salvarArquivo(String nomeArquivo) {
        String diretorioDestino = "C:" + File.separator + "desenv"
                + File.separator + "imagens" + File.separator;
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
        return "http://localhost:8080/imagens/" + nomeArquivo;
    }

}
