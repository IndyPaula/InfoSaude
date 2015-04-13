package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;


/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public interface DaoIF {

    boolean salvar(EntidadeBase entidadeBase);
    
    boolean atualizar(EntidadeBase entidadeBase);
    
}
