package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class LoginAdminDao extends GenericoDao<LoginAdmin> implements LoginAdminDaoIF {

    public LoginAdminDao() {
        super(LoginAdmin.class);
    }

    @Override
    public LoginAdmin efetuarLogin(String login, String senha) {

        Query typedQuery = getEntityManager().createNativeQuery(
                
                "SELECT * FROM login_admin  WHERE login =  '"
                        +login+"' AND senha = '"+CriptografiaUtil.convertStringToMd5(senha)+"'" , LoginAdmin.class);

        List users = typedQuery.getResultList();

        if (users.size() == 1) {

            LoginAdmin userFound = (LoginAdmin) users.get(0);

            return userFound;

        }else{

            return null;
        }
      
    }

}
