package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.FuncionarioDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.FuncionarioDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.FuncionarioServiceIF;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public class FuncionarioService extends GenericoService<Funcionario> implements FuncionarioServiceIF {

    private FuncionarioDaoIF dao;

    public FuncionarioService() {
        this.dao = new FuncionarioDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }
}
