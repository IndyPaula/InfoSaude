package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FuncionarioDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FuncionarioServiceIF;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class FuncionarioService extends GenericoService<Funcionario> implements FuncionarioServiceIF, Serializable {

    private static final Long serialVersionUID = 1L;

    @Inject
    private transient FuncionarioDaoIF dao;

    public FuncionarioService() {
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }
}
