package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class LoginAdminService extends GenericoService<LoginAdmin> implements LoginAdminServiceIF {

    private static final Long serialVersionUID = 1L;

    @Inject
    private LoginAdminDaoIF dao;

    public LoginAdminService() {
    }

    @Override
    public LoginAdmin efetuarLogin(String login, String senha) {
        return dao.efetuarLogin(login, senha);
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
