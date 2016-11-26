package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_venda;
    @ManyToOne
    private Setor id_setor;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Endereco id_endereco;
    @OneToOne
    private FormaPagamento formaPagamento;
    private int quantidade;
    private double valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_cadastro;
    private boolean status;

    public long getId_venda() {
        return id_venda;
    }

    public void setId_venda(long id_venda) {
        this.id_venda = id_venda;
    }

    public Setor getId_setor() {
        return id_setor;
    }

    public void setId_setor(Setor id_setor) {
        this.id_setor = id_setor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Endereco getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Endereco id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

}
