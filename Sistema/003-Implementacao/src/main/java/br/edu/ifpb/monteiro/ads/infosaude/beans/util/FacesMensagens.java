package br.edu.ifpb.monteiro.ads.infosaude.beans.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/05/2015
 */
public class FacesMensagens implements Serializable {

    private static final long serialVersionUID = 1L;

    private void add(String mensagem, Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(mensagem);
        facesMessage.setSeverity(severity);

        context.addMessage(null, facesMessage);
    }

    public void info(String mensagem) {
        add(mensagem, FacesMessage.SEVERITY_INFO);
    }

    public void error(String mensagem) {
        add(mensagem, FacesMessage.SEVERITY_ERROR);
    }
}
