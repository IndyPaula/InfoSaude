package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.AtendimentoImunizacaoDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.AtendimentoImunizacao;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.AtendimentoImunizacaoServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class AtendimentoImunizacaoService extends GenericoService<AtendimentoImunizacao> implements AtendimentoImunizacaoServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient AtendimentoImunizacaoDaoIF dao;

    public AtendimentoImunizacaoService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
