package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PacienteDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
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
    private transient PacienteDaoIF dao;

    public PacienteService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

    @Override
    public boolean cpfExiste(Long id, String cpf) throws ServiceExcecoes, DaoExcecoes {

        Paciente paciente = null;
        if (id == null) {
            paciente = dao.buscarPorCampo("cpf", cpf);

            if (paciente != null) {

                throw new DaoExcecoes("O CPF informado pertence a " + paciente.getNome() + ", por favor informe outro.");
            }
        } else {
            
            paciente = dao.buscarPorCampo("cpf", cpf);
            
            if (paciente != null && id != paciente.getId()) {

                throw new DaoExcecoes("O CPF informado pertence a " + paciente.getNome() + ", por favor informe outro.");
            }

            return true;
        }
        return true;
    }

}
