package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public interface ControleEstoqueVacinaServiceIF extends ServiceIF<ControleEstoqueVacina> {

    int quantidadeDeVacina(Vacina vacina) throws ServiceExcecoes;

    int verificarVacinaRemover(Vacina vacina) throws ServiceExcecoes;

}
