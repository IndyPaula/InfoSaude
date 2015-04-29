package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.UnidadeSaudeDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.UnidadeSaudeDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.UnidadeSaudeServiceIF;
import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class UnidadeSaudeService extends GenericoService<UnidadeSaude> implements UnidadeSaudeServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    private UnidadeSaudeDaoIF dao;

    public UnidadeSaudeService() {
        this.dao = new UnidadeSaudeDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
