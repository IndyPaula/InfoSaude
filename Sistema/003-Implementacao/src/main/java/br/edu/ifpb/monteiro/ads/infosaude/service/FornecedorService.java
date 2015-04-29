package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.FornecedorDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FornecedorDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Fornecedor;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FornecedorServiceIF;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class FornecedorService extends GenericoService<Fornecedor> implements FornecedorServiceIF {

    private FornecedorDaoIF dao;

    public FornecedorService() {
        this.dao = new FornecedorDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
