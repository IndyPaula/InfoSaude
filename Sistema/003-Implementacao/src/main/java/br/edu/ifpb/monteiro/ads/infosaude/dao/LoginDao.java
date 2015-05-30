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
                    "SELECT * FROM funcionario, acs WHERE funcionario.id = acs.id AND "
                    + "login =  '"+ login + "' AND senha = '"
                    + CriptografiaUtil.convertStringToMd5(senha) + "'", ACS.class);

            Query queryVacinador = getEntityManager().createNativeQuery(
                    "SELECT * FROM funcionario, vacinador  WHERE funcionario.id = vacinador.id AND "
                    + "login =  '" + login + "' AND senha = '"
                    + CriptografiaUtil.convertStringToMd5(senha) + "'", Vacinador.class);

            if (queryAcs.getResultList().size() > 0) {
                ACS a = (ACS) queryAcs.getResultList().get(0);
                return a;

            }

            if (queryVacinador.getResultList().size() > 0) {
                Vacinador v = (Vacinador) queryVacinador.getResultList().get(0);
                return v;
            }
        }
        return null;
    }

}
