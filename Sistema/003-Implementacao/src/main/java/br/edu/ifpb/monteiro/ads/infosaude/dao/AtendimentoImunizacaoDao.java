package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.AtendimentoImunizacaoDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.AtendimentoImunizacao;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 07/04/2015
 */
public class AtendimentoImunizacaoDao extends GenericoDao<AtendimentoImunizacao> implements AtendimentoImunizacaoDaoIF{

    public AtendimentoImunizacaoDao() {
        super(AtendimentoImunizacao.class);
    }
    
    
    
}
