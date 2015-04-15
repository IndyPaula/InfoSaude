package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.LoginAdminService;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 01/04/2015
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UserLoginBean implements Serializable {

    private LoginAdminServiceIF service;
    private String login;
    private String senha;
    private LoginAdmin admLogado;

    private boolean loggedIn;

    public UserLoginBean() {

        service = new LoginAdminService();
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

    public String doLogin() {
        LoginAdmin usuarioFound = (LoginAdmin) service.efetuarLogin(login, senha);

        if (usuarioFound == null) {
            JsfUtil.addErrorMessage("Usuário e senha inválidos");
            
            FacesContext.getCurrentInstance().validationFailed();

            return null;
        } else {
            loggedIn = true;
            admLogado = usuarioFound;

            JsfUtil.addSuccessMessage("Bem vindo");

            return "/resources/template/template_base.xhtml?faces-redirect=true";
        }
    }
    //Realiza o logout do usuário logado

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
