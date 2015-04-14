package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import java.security.MessageDigest;
import java.util.List;

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
        try {
            login = login.toLowerCase().trim();
            System.out.println("Verificando login do usuário " + login);

            List retorno = getEntityManager().createQuery(
                    "SELECT c FROM LoginAdmin  WHERE c.login = :login AND c.senha = :senha")
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getResultList();

            if (retorno.size() == 1) {
                LoginAdmin userFound = (LoginAdmin) retorno.get(0);
                return userFound;

            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("MD5");

            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
