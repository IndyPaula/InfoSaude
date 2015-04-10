package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
public class PacienteDao extends GenericoDao<Paciente>{

    public PacienteDao() {
        super(Paciente.class);
    }

}
