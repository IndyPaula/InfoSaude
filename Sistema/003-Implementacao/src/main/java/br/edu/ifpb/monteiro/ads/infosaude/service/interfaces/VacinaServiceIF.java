package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import java.util.Date;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public interface VacinaServiceIF extends ServiceIF<Vacina> {

    public void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim);

    public void relatorioVacinaImunobiologico(Date dataInicio, Date dataFim);
    
}
