package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.ArrayList;
import java.util.List;
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
                    "SELECT * FROM funcionario WHERE login_admin =  '"
                    + login + "' AND senha_admin = '" + CriptografiaUtil.convertStringToMd5(senha) + "'", ACS.class);

            Query queryVacinador = getEntityManager().createNativeQuery(
                    "SELECT * FROM funcionario  WHERE login_admin =  '"
                    + login + "' AND senha_admin = '" + CriptografiaUtil.convertStringToMd5(senha) + "'", Vacinador.class);

            List users = new ArrayList<>();

            try {
                if (queryAcs.getResultList().get(0) != null) {
                    users.add(queryAcs.getResultList().get(0));
                    ACS a = (ACS) queryAcs.getResultList().get(0);
                    return a;

                }
            } catch (IndexOutOfBoundsException ex) {
            }

            try {
                if (queryVacinador.getResultList().get(0) != null) {
                    users.add(queryVacinador.getResultList().get(0));
                    Vacinador v = (Vacinador) queryVacinador.getResultList().get(0);
                    return v;
                }
            } catch (IndexOutOfBoundsException ex) {
            }

            if (users.size() == 1) {

                Funcionario userFound = (Funcionario) users.get(0);

                return userFound;

            }
            return null;
        }
        return null;
    }

}
