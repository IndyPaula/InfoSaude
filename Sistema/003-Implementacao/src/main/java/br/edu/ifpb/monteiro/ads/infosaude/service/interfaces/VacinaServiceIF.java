package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.Date;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public interface VacinaServiceIF extends ServiceIF<Vacina> {

    void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim) throws ServiceExcecoes;

    void relatorioVacinaImunobiologico(Date dataInicio, Date dataFim) throws ServiceExcecoes;

}
