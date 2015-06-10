package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public interface ACSDaoIF extends DaoIF<ACS> {
    
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws DaoExcecoes;

}
