package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.UnidadeSaudeDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class UnidadeSaudeDao extends GenericoDao<UnidadeSaude> implements UnidadeSaudeDaoIF {

    public UnidadeSaudeDao() {
        super(UnidadeSaude.class);
    }

    @Override
    public UnidadeSaude salvar(UnidadeSaude entidade) throws DaoExcecoes {

        Query query = getEntityManager().createQuery("select t from unidade_saude t");

        if (query.getResultList().isEmpty()) {
            getEntityManager().persist(entidade);
        } else {
            throw new DaoExcecoes();
        }
        return entidade;
    }

}
