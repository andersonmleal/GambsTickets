package bean;

import entidade.Endereco;
import entidade.Telefone;
import entidade.Usuario;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private String mensagem;
    private Date dataCadastrada;

    public UsuarioBean() {
        usuario = new Usuario();
        endereco = new Endereco();
    }

    public String salvar() {
        long usuarioLng = usuario.getCpf();
        usuarioJPA = new UsuarioJPA();
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);
        if (!user.isEmpty()) {
            mensagem = "CPF já cadastrado no sistema!";
        } else if (!validarCPF(Long.toString(usuarioLng))) {
            mensagem = "CPF inválido!";
        } else if (!usuario.getEmail().equals(cnfEmail)) {
            mensagem = "E-mail difere da confirmação!";
        } else if (!usuario.getSenha().equals(cnfSenha)) {
            mensagem = "Senha difere da confirmação!";
        } else {
            adicionarUsuario();

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
        cnfEmail = "";
        cnfSenha = "";
    }

    public void alterarUsuario() {
        usuarioJPA = new UsuarioJPA();
        EnderecoJPA enderJPA = new EnderecoJPA();
        usuarioJPA.alterar(usuario);
        enderJPA.alterar(endereco);
    }

    public void adicionarUsuario() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        dtNasc = dtNasc.replace('-', '/');
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
        mensagem = "Cadastro realizado com sucesso!!!";
    }

    public void carregaUsuario() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            if (usuario.getDtNascimento() != null) {
                dtNasc = format.format(usuario.getDtNascimento());
                dtNasc = dtNasc.replace('/', '-');
                dtNasc = format.format(usuario.getDtNascimento());
                String d[] = dtNasc.split("/");
                String dateFormatado = d[1] + "-" + d[0] + "-" + d[2];
                this.dtNasc = dateFormatado;
                dataCadastrada = usuario.getDtNascimento();
            }
            endereco = usuario.getEnderecos().get(0);
            telefone = Long.toString(usuario.getTelefones().get(0).getNumero());

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

    public Boolean validarCPF(String cpf) {
        int soma = 0, indice = 8, contador = 10;
        Integer vetor[] = new Integer[11];
        Character vetorChar[] = new Character[11];

        if (cpf.length() < 11) {
            return false;
        }
        for (int i = 0; i < cpf.length(); i++) {
            vetorChar[i] = cpf.charAt(i);
            vetor[i] = Character.getNumericValue(vetorChar[i]);
        }
        for (int i = 0; i < cpf.length() - 2; i++) {
            soma = soma + (vetor[i] * contador);
            contador--;
        }
        int pDigito = 11 - (soma % 11);
        if (pDigito == 10 || pDigito == 11) {
            pDigito = 0;
        }

        contador = 11;
        soma = 0;
        for (int i = 0; i < cpf.length() - 1; i++) {
            soma = soma + (vetor[i] * contador);
            contador--;
        }
        int sDigito = 11 - (soma % 11);
        if (sDigito == 10 || sDigito == 11) {
            sDigito = 0;
        }
        return pDigito == vetor[9] && sDigito == vetor[10];
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioJPA getUsuarioJPA() {
        return usuarioJPA;
    }

    public String getCnfEmail() {
        return cnfEmail;
    }

    public void setCnfEmail(String cnfEmail) {
        this.cnfEmail = cnfEmail;
    }

    public String getCnfSenha() {
        return cnfSenha;
    }

    public void setCnfSenha(String cnfSenha) {
        this.cnfSenha = cnfSenha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public Date getDataCadastrada() {
        return dataCadastrada;
    }

    public void setDataCadastrada(Date dataCadastrada) {
        this.dataCadastrada = dataCadastrada;
    }

}
