package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ACSDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class ACSDao extends GenericoDao<ACS> implements ACSDaoIF {

    public ACSDao() {
        super(ACS.class);
    }

   @Override
    public void remover(ACS entity) {

        Query queryVacinador = getEntityManager().createNativeQuery("DELETE FROM acs WHERE id = " + entity.getId());
        queryVacinador.executeUpdate();
        
        Query queryFuncionario = getEntityManager().createNativeQuery("DELETE FROM funcionario WHERE id = " + entity.getId());
        queryFuncionario.executeUpdate();

        Query queryPessoa = getEntityManager().createNativeQuery("DELETE FROM pessoa WHERE id = " + entity.getId());
        queryPessoa.executeUpdate();

        getEntityManager().getTransaction().commit();

    }
}
