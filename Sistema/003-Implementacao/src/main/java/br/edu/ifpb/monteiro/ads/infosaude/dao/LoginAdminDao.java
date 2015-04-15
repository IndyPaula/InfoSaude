package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import java.security.MessageDigest;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<LoginAdmin> criteriaQuery = criteriaBuilder.createQuery(LoginAdmin.class);
        Root<LoginAdmin> usu = criteriaQuery.from(LoginAdmin.class);

        criteriaQuery.where(criteriaBuilder.equal(usu.get("login"), login));
        criteriaQuery.where(criteriaBuilder.equal(usu.get("senha"), senha));

        Query typedQuery = getEntityManager().createNativeQuery(
                
                "SELECT * FROM login_admin  WHERE login =  '"+login+"' AND senha = '"+senha+"'" , LoginAdmin.class);

        List users = typedQuery.getResultList();

        if (users.size() == 1) {

            LoginAdmin userFound = (LoginAdmin) users.get(0);
            System.err.println("--- ENCONTRADO");

            return userFound;

        }else{
            System.err.println("-- NADA ");

            return null;
        }

//        try {
//            senha = senha.toLowerCase().trim();
//
//            System.out.println("Verificando login do usuário " + login);
//
//            List retorno = getEntityManager().createQuery("FROM LoginAdmin'").getResultList();
//
//            System.err.println(retorno.get(0));
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
      
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
