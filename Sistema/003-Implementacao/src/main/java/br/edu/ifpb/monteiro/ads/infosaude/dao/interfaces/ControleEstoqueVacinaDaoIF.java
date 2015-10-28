package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public interface ControleEstoqueVacinaDaoIF extends DaoIF<ControleEstoqueVacina> {
    
    int quantidadeDeVacina(Vacina vacina) throws DaoExcecoes;
    
    int verificarVacinaRemover(Vacina vacina) throws DaoExcecoes;
    
}
