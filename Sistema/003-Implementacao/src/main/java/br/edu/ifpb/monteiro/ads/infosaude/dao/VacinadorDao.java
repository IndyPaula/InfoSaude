package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinadorDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
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

}
