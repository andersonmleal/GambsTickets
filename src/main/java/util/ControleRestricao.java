/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.LoginBean;
import entidade.Usuario;
import javax.faces.FacesWrapper;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gustavo
 */
public class ControleRestricao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext faces = event.getFacesContext();
        Application application = faces.getApplication();
        NavigationHandler navigationHandles = application.getNavigationHandler();

        HttpSession session = (HttpSession) faces.getExternalContext().getSession(false);
        int tipo = 0;
        if (session != null) {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario != null) {
                tipo = usuario.getTipo_usuario();
            }
        }

        String pagina = faces.getViewRoot().getViewId();
        if (pagina.equals("/alteraEvento.xhtml") && (tipo != 1)) {
            navigationHandles.handleNavigation(faces, null, "/index.xhtml");
        } else if (pagina.equals("/graficos.xhtml") && (tipo != 1)) {
            navigationHandles.handleNavigation(faces, null, "/index.xhtml");
        } else if (pagina.equals("/eventosCadastro.xhtml") && (tipo != 1)) {
            navigationHandles.handleNavigation(faces, null, "/index.xhtml");
        }else if (pagina.equals("/relatorios.xhtml") && (tipo != 1)) {
            navigationHandles.handleNavigation(faces, null, "/index.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
