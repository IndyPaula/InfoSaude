package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 07/04/2015
 */
public class VacinaDao extends GenericoDao<Vacina> implements VacinaDaoIF {

    public VacinaDao() {
        super(Vacina.class);
    }

    @Override
    public void remover(Vacina entity) {

        getEntityManager().getTransaction().begin();

        Query queryPaciente = getEntityManager().createNativeQuery("DELETE FROM vacina WHERE id = " + entity.getId());
        queryPaciente.executeUpdate();

        getEntityManager().getTransaction().commit();

        getEntityManager().close();

    }
}
