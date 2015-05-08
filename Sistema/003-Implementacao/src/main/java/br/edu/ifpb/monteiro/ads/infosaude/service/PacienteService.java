package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PacienteDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PacienteServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class PacienteService extends GenericoService<Paciente> implements PacienteServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private PacienteDaoIF dao;

    public PacienteService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }
}
