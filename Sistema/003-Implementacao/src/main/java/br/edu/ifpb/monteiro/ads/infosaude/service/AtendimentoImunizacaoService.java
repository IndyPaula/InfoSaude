package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.AtendimentoImunizacaoDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.AtendimentoImunizacaoDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.AtendimentoImunizacao;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.AtendimentoImunizacaoServiceIF;
import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class AtendimentoImunizacaoService extends GenericoService<AtendimentoImunizacao> implements AtendimentoImunizacaoServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    private AtendimentoImunizacaoDaoIF dao;

    public AtendimentoImunizacaoService() {
        this.dao = new AtendimentoImunizacaoDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
