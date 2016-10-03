package entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Evento")
public class Evento implements Serializable {

    @Id
    private long id_evento;
    private String nome_evento;
    private String local_evento;
    private Date dt_evento;
    private Date dt_cadastro_evento;
    private boolean status;
    private String caminhoImagem;
    private String caminhoImagemBack;
    private String descricao;
    private ArrayList <Setor> setores;

    public Evento() {
        setores = new ArrayList<>();
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setSetores(ArrayList<Setor> setores) {
        this.setores = setores;
    }
    
    

    public ArrayList<Setor> getSetores() {
        return setores;
    }

    public void addSetores(Setor setor) {
        
        setores.add(setor);
    }

    public String getCaminhoImagemBack() {
        return caminhoImagemBack;
    }

    public void setCaminhoImagemBack(String caminhoImagemBack) {
        this.caminhoImagemBack = caminhoImagemBack;
    }

    
    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    
    public long getId_evento() {
        return id_evento;
    }

    public void setId_evento(long id_evento) {
        this.id_evento = id_evento;
    }

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public String getLocal_evento() {
        return local_evento;
    }

    public void setLocal_evento(String local_evento) {
        this.local_evento = local_evento;
    }

    public Date getDt_evento() {
        return dt_evento;
    }

    public void setDt_evento(Date dt_evento) {
        this.dt_evento = dt_evento;
    }

    public Date getDt_cadastro_evento() {
        return dt_cadastro_evento;
    }

    public void setDt_cadastro_evento(Date dt_cadastro_evento) {
        this.dt_cadastro_evento = dt_cadastro_evento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
