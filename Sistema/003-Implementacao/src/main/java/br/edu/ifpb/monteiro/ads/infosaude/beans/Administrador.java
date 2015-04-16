package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.FuncionarioService;
import br.edu.ifpb.monteiro.ads.infosaude.service.LoginAdminService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 16/04/2015
 */
@ManagedBean(name = "administrador")
@SessionScoped
public class Administrador {

     private LoginAdminServiceIF service;
     
    private String confirmarSenha;
    private LoginAdmin admin;
    
    
    public Administrador() {

        service = new LoginAdminService();
    }
    
    public List<Integer> matriculas() throws ServiceExcecoes{
        List<Integer> matriculas = null;
             List<Funcionario> f = new FuncionarioService().buscarTudo();
             for (Funcionario f1 : f) {
                 matriculas.add(f1.getMatricula());
             }
         return matriculas;
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
    
    
}
