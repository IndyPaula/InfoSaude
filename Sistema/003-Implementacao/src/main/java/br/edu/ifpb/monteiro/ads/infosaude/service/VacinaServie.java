package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.relatorios.RelatorioVacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class VacinaServie extends GenericoService<Vacina> implements VacinaServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    RelatorioVacina relatorioVacina;

    @Inject
    private transient VacinaDaoIF dao;

    public VacinaServie() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public void remover(Vacina vac) {

        try {
            dao.remover(vac);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinaServie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim) {
        relatorioVacina.relatorioVacinaPorDataDeValidade(dataInicio, dataFim);
    }

    @Override
    public void relatorioVacinaImunobiologico(Date dataInicio, Date dataFim) {
        relatorioVacina.relatorioVacinaImunobiologico(dataInicio, dataFim);
    }
}
