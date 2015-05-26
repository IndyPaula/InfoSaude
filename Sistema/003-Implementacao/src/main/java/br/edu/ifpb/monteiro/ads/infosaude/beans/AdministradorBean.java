package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 16/04/2015
 */
@Model
public class AdministradorBean implements Serializable {

    private String confirmarSenha;
    private Integer matFuncionario;

    @Inject
    private transient LoginAdminServiceIF service;

    @Inject
    private LoginAdmin loginAdmin;

    public AdministradorBean() {
    }
    
    
    @PostConstruct
    public void init(){
//        matriculas();
        
    }
//    public List<Integer> matriculas() {
//        List<Integer> lista = new ArrayList<>();
//        try {
//            for (Funcionario f : funcionarioServiceIF.buscarTudo()) {
//                System.out.println(f.getId());
//                lista.add(f.getMatricula());
//            }
//        } catch (ServiceExcecoes ex) {
//            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lista;
//    }

//    public String salvar() {
//        try {
//            Funcionario f1 = new LoginAdmin();
//            f1 = f.buscarPorCampo("matricula", matFuncionario);
//            service.salvar(getEntidade());
//        } catch (ServiceExcecoes ex) {
//            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "/resources/paginas/ubs/buscar_admin.xhtml";
//    }
//
//    public void buscarPorNome() {
//        try {
//            identificavel = (LoginAdmin) service.buscarPorCampo("login", identificavel.getLogin());
//            setEntidade(identificavel);
//        } catch (ServiceExcecoes ex) {
//            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public Integer getMatFuncionario() {
        return matFuncionario;
    }

    public void setMatFuncionario(Integer matFuncionario) {
        this.matFuncionario = matFuncionario;
    }

    public LoginAdminServiceIF getService() {
        return service;
    }

    public void setService(LoginAdminServiceIF service) {
        this.service = service;
    }

    public LoginAdmin getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(LoginAdmin loginAdmin) {
        this.loginAdmin = loginAdmin;
    }
    
}
