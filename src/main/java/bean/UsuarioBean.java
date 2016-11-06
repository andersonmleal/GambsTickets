package bean;

import entidade.Usuario;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "cadastroUsuarioBean")
@Dependent
public class UsuarioBean {

    /**
     * Creates a new instance of CadastroUsuarioBean
     */
    private Usuario usuario = new Usuario();

    public UsuarioBean() {
    }

    public String adicionarUsuario() {
        //usuarioDao.addUsuario(usuario);
        return "sucesso";

    }

    public String removeUsuario() {
        //usuarioDao.removeUsuario(usuario);
        return "sucesso";

    }
}
