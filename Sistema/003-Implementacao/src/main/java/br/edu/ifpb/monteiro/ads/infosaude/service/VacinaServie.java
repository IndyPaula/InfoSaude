package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.VacinaDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class VacinaServie extends GenericoService<Vacina> implements VacinaServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    private VacinaDaoIF dao;

    public VacinaServie() {
        this.dao = new VacinaDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
