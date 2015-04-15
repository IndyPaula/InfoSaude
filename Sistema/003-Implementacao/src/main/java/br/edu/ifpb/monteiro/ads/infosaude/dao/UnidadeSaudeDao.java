package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.UnidadeSaudeDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class UnidadeSaudeDao extends GenericoDao<UnidadeSaude> implements UnidadeSaudeDaoIF {

    public UnidadeSaudeDao() {
        super(UnidadeSaude.class);
    }

}
