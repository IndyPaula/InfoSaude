package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.FuncionarioService;
import br.edu.ifpb.monteiro.ads.infosaude.service.LoginAdminService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FuncionarioServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 16/04/2015
 */
@ManagedBean(name = "administrador")
@SessionScoped
public class Administrador implements Serializable {

    private LoginAdminServiceIF service;
    private FacesContext contexto;
    private String confirmarSenha;
    private LoginAdmin admin;
    private Integer matFuncionario;
    private List<LoginAdmin> administradores;
    private LoginAdmin adminTemp;

    public Administrador() throws ServiceExcecoes {
        this.contexto = FacesContext.getCurrentInstance();
        service = new LoginAdminService();
        admin = new LoginAdmin();
        adminTemp = new LoginAdmin();
        matriculas();
        administradores = service.buscarTudo();
    }

    public List<Integer> matriculas() throws ServiceExcecoes {
        FuncionarioServiceIF f = new FuncionarioService();
        List<Funcionario> f1 = f.buscarTudo();
        List<Integer> lista = new ArrayList<>();
        for (Funcionario f11 : f1) {
            lista.add(f11.getMatricula());
        }
        return lista;
    }

    public String salvar() {
        try {
            FuncionarioServiceIF f = new FuncionarioService();
            Funcionario f1 = new Funcionario();
            f1 = f.buscarPorCampo("matricula", matFuncionario);
            admin.setFuncionario(f1);
            service.salvar(admin);
            administradores = service.buscarTudo();
            admin = new LoginAdmin();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/resources/paginas/ubs/buscar_admin.xhtml";
    }

    public String atualizar() throws ServiceExcecoes {
        adminTemp.setNome(admin.getNome());
        adminTemp.setSenha(admin.getSenha());
        admin = new LoginAdmin();
        try {
            service.atualizar(adminTemp);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String remover(LoginAdmin ad) {
        try {
            service.remover(ad.getId());
            administradores = service.buscarTudo();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void buscarPorNome() {
        try {
            admin = service.buscarPorCampo("login", admin.getNome());
            adminTemp = admin;
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LoginAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(LoginAdmin admin) {
        this.admin = admin;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public LoginAdminServiceIF getService() {
        return service;
    }

    public void setService(LoginAdminServiceIF service) {
        this.service = service;
    }

    public Integer getMatFuncionario() {
        return matFuncionario;
    }

    public void setMatFuncionario(Integer matFuncionario) {
        this.matFuncionario = matFuncionario;
    }

    public List<LoginAdmin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<LoginAdmin> administradores) {
        this.administradores = administradores;
    }

}
