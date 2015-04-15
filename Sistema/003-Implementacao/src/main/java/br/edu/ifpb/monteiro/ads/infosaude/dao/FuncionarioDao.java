package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FuncionarioDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class FuncionarioDao extends GenericoDao<Funcionario> implements FuncionarioDaoIF {

    public FuncionarioDao() {
        super(Funcionario.class);
    }

}