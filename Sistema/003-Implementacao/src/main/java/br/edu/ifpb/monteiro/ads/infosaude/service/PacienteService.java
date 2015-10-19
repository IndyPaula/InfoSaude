package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PacienteDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PacienteServiceIF;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class PacienteService extends GenericoService<Paciente> implements PacienteServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient PacienteDaoIF dao;

    public PacienteService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws ServiceExcecoes, DaoExcecoes {

        try {

            Paciente paciente = null;

            if (id == null) {
                paciente = dao.buscarPorCampo(campo, valor);
                if (paciente != null) {
                    throw new DaoExcecoes("O "+campo.toUpperCase()+" informado pertence a outra pessoa, por favor informe outro.");
                }
            } else {
                paciente = dao.buscarPorCampo(campo, valor);
                if (paciente != null && id != paciente.getId()) {
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
