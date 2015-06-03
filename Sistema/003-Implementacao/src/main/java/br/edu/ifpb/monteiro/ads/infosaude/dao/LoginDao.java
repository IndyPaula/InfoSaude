package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 28/05/2015
 */
public class LoginDao extends GenericoDao<Funcionario> implements LoginDaoIF {

    public LoginDao() {
        super(Funcionario.class);
    }

    @Override
    public Funcionario efetuarLogin(String login, String senha) {

        if (login != null && senha != null) {

            Query queryAcs = getEntityManager().createNativeQuery(
                    "SELECT * FROM funcionario f, acs a, pessoa p WHERE f.id =  a.id AND p.id = f.id AND "
                    + "login =  '"+ login + "' AND f.senha = '"
                    + CriptografiaUtil.convertStringToMd5(senha) + "' AND f.adm = 's' ", ACS.class);

            Query queryVacinador = getEntityManager().createNativeQuery(
                    "SELECT * FROM funcionario f, vacinador v, pessoa p WHERE f.id =  v.id AND p.id = f.id AND "
                    + "login =  '" + login + "' AND f.senha = '"
                    + CriptografiaUtil.convertStringToMd5(senha) + "' AND f.adm = 's' ", Vacinador.class);

            if (queryAcs.getResultList().size() > 0) {
                
                return (ACS) queryAcs.getResultList().get(0);

            }

            if (queryVacinador.getResultList().size() > 0) {

                return (Vacinador) queryVacinador.getResultList().get(0);
            
            }
        }
        return null;
    }

}
