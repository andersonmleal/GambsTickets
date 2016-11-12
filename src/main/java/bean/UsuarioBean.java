package bean;

import entidade.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{

    /**
     * Creates a new instance of CadastroUsuarioBean
     */
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioBean() {
       usuario = new Usuario();
    }

    public String adicionarUsuario() {
        System.out.print("teste");
        return "sucesso";

    }

    public String removeUsuario() {
        //usuarioDao.removeUsuario(usuario);
        return "sucesso";

    }
}
