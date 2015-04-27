package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PessoaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 03/04/2015
 */
public class PessoaDao extends GenericoDao<Pessoa> implements PessoaDaoIF {

    public PessoaDao() {
        super(Pessoa.class);
    }

}
