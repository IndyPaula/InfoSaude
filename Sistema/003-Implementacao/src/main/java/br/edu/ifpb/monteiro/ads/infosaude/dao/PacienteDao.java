package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PacienteDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
public class PacienteDao extends GenericoDao<Paciente> implements PacienteDaoIF {

    public PacienteDao() {
        super(Paciente.class);
    }

    @Override
    public void remover(Paciente entity) {

        getEntityManager().getTransaction().begin();
        
        Query queryPaciente = getEntityManager().createNativeQuery("DELETE FROM paciente WHERE id = " + entity.getId());
        queryPaciente.executeUpdate();

        Query queryPessoa = getEntityManager().createNativeQuery("DELETE FROM pessoa WHERE id = " + entity.getId());
        queryPessoa.executeUpdate();

        getEntityManager().getTransaction().commit();

        getEntityManager().close();

    }
}
