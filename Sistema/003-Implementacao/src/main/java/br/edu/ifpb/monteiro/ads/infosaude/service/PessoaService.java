package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PessoaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PessoaServiceIF;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class PessoaService extends GenericoService<Pessoa> implements PessoaServiceIF {

    private PessoaDaoIF dao;

    public PessoaService() {
        this.dao = new PessoaDao();
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
