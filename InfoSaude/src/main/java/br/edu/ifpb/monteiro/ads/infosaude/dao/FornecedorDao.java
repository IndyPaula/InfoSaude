package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FornecedorDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Fornecedor;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 07/04/2015
 */
public class FornecedorDao extends GenericoDao<Fornecedor> implements FornecedorDaoIF {

    public FornecedorDao() {
        super(Fornecedor.class);
    }

    
    
}
