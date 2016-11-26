package bean;

import entidade.Endereco;
import entidade.Telefone;
import entidade.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
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
    private String telefone[];

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String[] getTelefone() {
        return telefone;
    }

    public void setTelefone(String[] telefone) {
        this.telefone = telefone;
    }

    public UsuarioBean() {
        usuario = new Usuario();
        endereco = new Endereco();
        telefone = new String[3];
    }

    public String salvar() {
        long usuarioLng = usuario.getCpf();
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);
        if (user.isEmpty()) {
            adicionarUsuario();
        } else {
            usuarioJPA.alterar(usuario);
        }
        return "cadastroUsuario.xhtml";
    }

    public void alterarUsuario() {

    }

    public void adicionarUsuario() {
        Calendar c = Calendar.getInstance();
        usuario.setDtCadastro(c.getTime());
        usuarioJPA = new UsuarioJPA();
        usuarioJPA.incluir(usuario);

        endereco.setDt_cadastro(c.getTime());
        endereco.setUsuario_evento(usuario);
        EnderecoJPA enderecoJPA = new EnderecoJPA();
        enderecoJPA.incluir(endereco);

        cadastrarTelefone(c);

        // Montar mensagem a ser apresentada para usuario
        //Flash mensagem = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        //mensagem.put("mensagem", new Mensagem("Cadastro realizado com sucesso", "success"));
    }

    public void cadastrarTelefone(Calendar c) {
        Telefone regTelefone = new Telefone();
        TelefoneJPA telefoneJPA = new TelefoneJPA();
        for (int contador = 0; contador < telefone.length; contador++) {
            if (telefone[contador] != null) {
                switch (contador) {
                    case 0:
                        regTelefone.setDescricao("Telefone Residencial");
                        break;
                    case 1:
                        regTelefone.setDescricao("Telefone Comercial");
                        break;
                    case 2:
                        regTelefone.setDescricao("Telefone Celular");
                        break;
                }
                regTelefone.setNumero(Long.parseLong(telefone[contador]));
                regTelefone.setUsuario(usuario);
                regTelefone.setDt_cadastro(c.getTime());
                telefoneJPA.incluir(regTelefone);
            }
        }
    }

    public String removeUsuario() {
        //usuarioDao.removeUsuario(usuario);
        return "sucesso";

    }
}
