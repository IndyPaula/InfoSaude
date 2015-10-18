package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ACSDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ACSServiceIF;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class ACSService extends GenericoService<ACS> implements ACSServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient ACSDaoIF dao;

    public ACSService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws ServiceExcecoes, DaoExcecoes {

        try {

            ACS acs = null;

            if (id == null) {
                acs = dao.buscarPorCampo(campo, valor);
                if (acs != null) {
                    throw new DaoExcecoes("O "+campo.toUpperCase()+" informado pertence a outra pessoa, por favor informe outro.");
                }
            } else {
                acs = dao.buscarPorCampo(campo, valor);
                if (acs != null && id != acs.getId()) {
                    throw new DaoExcecoes("O "+campo.toUpperCase()+" informado pertence a outra pessoa, por favor informe outro.");
                }
                return true;
            }
        } catch (NoResultException ex) {
            Logger.getLogger(VacinadorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
