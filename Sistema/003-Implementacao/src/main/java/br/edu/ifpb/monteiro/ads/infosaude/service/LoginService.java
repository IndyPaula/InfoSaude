package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class LoginService extends GenericoService<Funcionario> implements LoginServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient LoginDaoIF dao;

    public LoginService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public Funcionario efetuarLogin(String login, String senha) {
        return dao.efetuarLogin(login, senha);
    }

}
