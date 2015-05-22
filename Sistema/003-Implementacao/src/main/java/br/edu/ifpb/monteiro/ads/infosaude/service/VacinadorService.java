package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinadorServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class VacinadorService extends GenericoService<Vacinador> implements VacinadorServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient VacinaDaoIF dao;

    public VacinadorService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
