/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import jpa.UsuarioJPA;

/**
 *
 * @author Thiago
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String senha;

    public LoginBean() {

    }

    public String realizarLogin() {
        boolean ok = validarUsuario(usuario, senha);
        if (ok) {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("usuario", this.usuario);
            return "index";
        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Erro de Login", "Usuario/Senha inválidos");
        FacesContext.getCurrentInstance().addMessage(null, fm);
        return "loginErro";
    }

    public String recuperaUsuario() {
        //ServletRequest req = null;
        //HttpServletRequest request = (HttpServletRequest) req;
        //HttpSession session = (HttpSession) request.getSession();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        String UsuarioSession = session.getAttribute("usuario").toString();

        //JOptionPane.showInputDialog(UsuarioSession);

        return UsuarioSession;
    }

    public boolean validarUsuario(String usuario, String senha) {
        UsuarioJPA usuarioJPA = new UsuarioJPA();
        long usuarioLng = Long.parseLong(usuario);
        List<Usuario> user = usuarioJPA.verificaCadastro(usuarioLng);
        if (user.isEmpty()) {
            return false;
        } else if (usuarioLng == user.get(0).getCpf() && senha.equals(user.get(0).getSenha())) {
            //ConclusaoCompraManagedBean userBean = new ConclusaoCompraManagedBean();
            //userBean.setUsuario(user.get(0));
            return true;
        } else {
            return false;
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
