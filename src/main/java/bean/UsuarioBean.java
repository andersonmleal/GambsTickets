package bean;

import entidade.Endereco;
import entidade.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import jpa.UsuarioJPA;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of CadastroUsuarioBean
     */
    private Usuario usuario;
    private Endereco endereco;
    private UsuarioJPA usuarioJPA;

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
    
    public UsuarioBean() {
       usuario = new Usuario();
       endereco = new Endereco();
    }

    public String adicionarUsuario() {
        Calendar c = Calendar.getInstance();
        usuario.setDtCadastro(c.getTime());
        
        usuarioJPA = new UsuarioJPA();
        usuarioJPA.incluir(usuario);
        
        EnderecoManagedBean ender = new EnderecoManagedBean();
        ender.cadastrar(usuario);
        
        System.out.print("teste");
        return "sucesso";

    }

    public String removeUsuario() {
        //usuarioDao.removeUsuario(usuario);
        return "sucesso";

    }
}
