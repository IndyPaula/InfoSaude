package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public interface LoginDaoIF extends DaoIF<Funcionario> {

    public Funcionario efetuarLogin(String login, String senha);

}
