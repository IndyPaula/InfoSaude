package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ControleEstoqueVacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ControleEstoqueVacinaServiceIF;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public class ControleEstoqueVacinaService extends GenericoService<ControleEstoqueVacina> implements ControleEstoqueVacinaServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient ControleEstoqueVacinaDaoIF dao;

    public ControleEstoqueVacinaService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public int quantidadeDeVacina(Vacina vacina) throws ServiceExcecoes {
        try {
            return dao.quantidadeDeVacina(vacina);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(ControleEstoqueVacinaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
