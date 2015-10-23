package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ControleEstoqueVacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ControleEstoqueVacinaServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public class ControleEstoqueVacinaService extends GenericoService<ControleEstoqueVacina> implements ControleEstoqueVacinaServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient ControleEstoqueVacinaDaoIF dao;

    public ControleEstoqueVacinaService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
