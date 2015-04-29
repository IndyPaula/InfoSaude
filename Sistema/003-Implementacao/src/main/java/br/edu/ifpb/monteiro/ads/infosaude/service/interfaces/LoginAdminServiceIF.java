package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
public interface LoginAdminServiceIF extends ServiceIF<LoginAdmin> {

    public LoginAdmin efetuarLogin(String login, String senha);

}
