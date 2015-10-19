package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinadorDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class VacinadorDao extends GenericoDao<Vacinador> implements VacinadorDaoIF {

    public VacinadorDao() {
        super(Vacinador.class);
    }

    @Override
    public void remover(Vacinador entity) {

        Query queryVacinador = getEntityManager().createNativeQuery("DELETE FROM vacinador WHERE id = " + entity.getId());
        queryVacinador.executeUpdate();

        Query queryFuncionario = getEntityManager().createNativeQuery("DELETE FROM funcionario WHERE id = " + entity.getId());
        queryFuncionario.executeUpdate();

        Query queryPessoa = getEntityManager().createNativeQuery("DELETE FROM pessoa WHERE id = " + entity.getId());
        queryPessoa.executeUpdate();

        getEntityManager().getTransaction().commit();

    }

    @Override
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws DaoExcecoes {
        Funcionario funcionario = null;

        Query queryVacinador = getEntityManager().createNativeQuery(
                "SELECT * FROM funcionario f, pessoa p WHERE p.id = f.id AND " + campo + " = '" + valor + "' ", Funcionario.class);
        try {

            funcionario = (Funcionario) queryVacinador.getSingleResult();
        } catch (NoResultException e) {
             Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, e);
             return true;
        }

        if (id != null && id == funcionario.getId()) {
            return true;
        }

        throw new DaoExcecoes("O " + campo.toUpperCase() + " informado pertence a outra pessoa, por favor informe outro.");
    }
}
