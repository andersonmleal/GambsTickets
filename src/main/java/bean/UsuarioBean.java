package bean;

import entidade.Endereco;
import entidade.Telefone;
import entidade.Usuario;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import jpa.EnderecoJPA;
import jpa.TelefoneJPA;
import jpa.UsuarioJPA;
import util.Mensagem;

@ManagedBean
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    /**
     * Creates a new instance of CadastroUsuarioBean
     */
    private Usuario usuario;
    private Endereco endereco;
    private UsuarioJPA usuarioJPA;
    private String telefone;
    private String telefoneComercial;
    private String telefoneCelular;
    private String dtNasc;
    private String cnfEmail;
    private String cnfSenha;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioJPA getUsuarioJPA() {
        return usuarioJPA;
    }

    public void setUsuarioJPA(UsuarioJPA usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public UsuarioBean() {
        usuario = new Usuario();
        endereco = new Endereco();
    }

    public String salvar() {
        long usuarioLng = usuario.getCpf();
        usuarioJPA = new UsuarioJPA();
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);
        if (user.isEmpty()) {
            adicionarUsuario();
        } else {

            //MENSAGEM DE QUE JÁ EXISTE CPF CADASTRADO.
        }
        return "cadastroUsuario.xhtml";
    }

    public void limpar() {
        usuario = new Usuario();
        endereco = new Endereco();
        dtNasc = null;
        telefone = "";
        telefoneCelular = "";
        telefoneComercial = "";
    }

    public void alterarUsuario() {
        usuarioJPA = new UsuarioJPA();
        usuarioJPA.alterar(usuario);
    }

    public void adicionarUsuario() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            usuario.setDtNascimento(new java.sql.Date(format.parse(dtNasc).getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuario.setDtCadastro(c.getTime());
        usuarioJPA = new UsuarioJPA();
        usuarioJPA.incluir(usuario);

        endereco.setDt_cadastro(c.getTime());
        endereco.setUsuario_evento(usuario);
        EnderecoJPA enderecoJPA = new EnderecoJPA();
        enderecoJPA.incluir(endereco);
        if (!telefone.equals("")) {
            cadastrarTelefone(c, telefone, "Telefone Residencial");
        }
        if (telefoneComercial != null) {
            if (!telefoneComercial.equals("")) {
                cadastrarTelefone(c, telefoneComercial, "Telefone Comercial");
            }
        }
        if (telefoneCelular != null) {
            if (!telefoneCelular.equals("")) {
                cadastrarTelefone(c, telefoneCelular, "Telefone Celular");
            }
        }
        limpar();
        // Montar mensagem a ser apresentada para usuario
        //Flash mensagem = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        //mensagem.put("mensagem", new Mensagem("Cadastro realizado com sucesso", "success"));
    }

    public void carregaUsuario() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            endereco = usuario.getEnderecos().get(0);
        } else {
            usuario = new Usuario();
            endereco = new Endereco();
        }
    }

    public void cadastrarTelefone(Calendar c, String tel, String descricao) {
        Telefone regTelefone = new Telefone();
        TelefoneJPA telefoneJPA = new TelefoneJPA();

        regTelefone.setDescricao(descricao);
        regTelefone.setNumero(Long.parseLong(tel));
        regTelefone.setUsuario(usuario);
        regTelefone.setDt_cadastro(c.getTime());
        telefoneJPA.incluir(regTelefone);

    }

    public String removeUsuario() {
        //usuarioDao.removeUsuario(usuario);
        return "sucesso";

    }
}
