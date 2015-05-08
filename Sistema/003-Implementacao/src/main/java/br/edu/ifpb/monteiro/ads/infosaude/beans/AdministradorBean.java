package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.FuncionarioService;
import br.edu.ifpb.monteiro.ads.infosaude.service.LoginAdminService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FuncionarioServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 16/04/2015
 */
//@ManagedBean(name = "administrador")
//@RequestScoped
@Named
public class AdministradorBean extends GenericoBeans<LoginAdmin> {

    @Override
    public String salvar() throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualizar() throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(LoginAdmin identificavel) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginAdmin consultarPorId(Long id) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginAdmin buscarPorCampo(String campo, Object valor) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoginAdmin> buscarTodosPorCampo(String campo, Object valor) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoginAdmin> buscarTudo() throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private String confirmarSenha;
//    private Integer matFuncionario;
//    private FuncionarioServiceIF f;
//
//    public AdministradorBean() throws ServiceExcecoes {
//        service = new LoginAdminService();
//        identificavel = new LoginAdmin();
//        f = new FuncionarioService();
//        matriculas();
//    }
//
//    public  List<Integer> matriculas() throws ServiceExcecoes {
//        List<Funcionario> f1 = f.buscarTudo();
//        List<Integer> lista = new ArrayList<>();
//        for (Funcionario f11 : f1) {
//            lista.add(f11.getMatricula());
//        }
//        return lista;
//    }
//
//    @Override
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
//
//    public String getConfirmarSenha() {
//        return confirmarSenha;
//    }
//
//    public void setConfirmarSenha(String confirmarSenha) {
//        this.confirmarSenha = confirmarSenha;
//    }
//
//    public LoginAdminServiceIF getService() {
//        return (LoginAdminService) service;
//    }
//
//    public void setService(LoginAdminServiceIF service) {
//        this.service = service;
//    }
//
//    public Integer getMatFuncionario() {
//        return matFuncionario;
//    }
//
//    public void setMatFuncionario(Integer matFuncionario) {
//        this.matFuncionario = matFuncionario;
//    }
//
//    @Override
//    public LoginAdmin getEntidade() {
//        if (identificavel == null) {
//            identificavel = new LoginAdmin();
//        }
//        return (LoginAdmin) identificavel;
//    }
//
//    @Override
//    public void setEntidade(LoginAdmin identificavel) {
//        this.identificavel = identificavel;
//    }

}
