package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FornecedorDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Fornecedor;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FornecedorServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class FornecedorService extends GenericoService<Fornecedor> implements FornecedorServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient FornecedorDaoIF dao;

    public FornecedorService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
