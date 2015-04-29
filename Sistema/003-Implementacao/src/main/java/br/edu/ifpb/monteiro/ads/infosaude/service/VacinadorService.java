package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.VacinaDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinadorServiceIF;
import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class VacinadorService extends GenericoService<Vacinador> implements VacinadorServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    private VacinaDaoIF dao;

    public VacinadorService() {
        this.dao = new VacinaDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }
}
