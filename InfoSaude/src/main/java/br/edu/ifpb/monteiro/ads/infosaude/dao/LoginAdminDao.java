package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class LoginAdminDao extends GenericoDao<LoginAdmin> implements LoginAdminDaoIF {

    public LoginAdminDao() {
        super(LoginAdmin.class);
    }

}
