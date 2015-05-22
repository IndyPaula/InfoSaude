package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 01/04/2015
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UserLoginBean implements Serializable {

    @Inject
    private transient LoginAdminServiceIF service;
    
    private static final long serialVersionUID = 682119314630735490L;

    private String login;
    private String senha;

    private LoginAdmin admLogado;

    private boolean loggedIn;

    public UserLoginBean() {
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LoginAdmin getAdmLogado() {
        return admLogado;
    }

    public void setAdmLogado(LoginAdmin admLogado) {
        this.admLogado = admLogado;
    }

    public String doLogin() {
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(UserLoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginAdmin usuarioFound = service.efetuarLogin(login, senha);

        if (usuarioFound == null) {
            JsfUtil.addErrorMessage("Usuário e senha inválidos");

            FacesContext.getCurrentInstance().validationFailed();

            return null;
        } else {
            
            loggedIn = true;
            setAdmLogado(usuarioFound);
            return "/resources/template/template_base.xhtml?faces-redirect=true";
        }
    }
    public String doLogout() {

        admLogado = null;
        loggedIn = false;
        JsfUtil.addSuccessMessage("Logout efetuado");
        return "/login.xhtml?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
