package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.LoginAdminDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class LoginAdminService extends GenericoService<LoginAdmin> implements LoginAdminServiceIF {

    private LoginAdminDaoIF dao;

    public LoginAdminService() {
        this.dao = new LoginAdminDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
