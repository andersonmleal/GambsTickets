package entidade;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Telefone")
public class Telefone {

    @Id
    private long id_telefone;
    private String descricao;
    private long usuario_evento;
    private Date dt_cadastro;
    private boolean status;

    public long getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(long id_telefone) {
        this.id_telefone = id_telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getUsuario_evento() {
        return usuario_evento;
    }

    public void setUsuario_evento(long usuario_evento) {
        this.usuario_evento = usuario_evento;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
