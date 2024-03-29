package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public interface LoginServiceIF extends ServiceIF<Funcionario> {

    public Funcionario efetuarLogin(String login, String senha);

}
