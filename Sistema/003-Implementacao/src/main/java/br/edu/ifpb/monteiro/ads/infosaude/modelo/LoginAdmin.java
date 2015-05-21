package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "login_admin")
public class LoginAdmin extends Funcionario implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "login", nullable = false, length = 45, unique = true)
    private String login;

    @Column(name = "senha_adm", nullable = false, length = 45, unique = false)
    private String senhaAdm;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = CriptografiaUtil.convertStringToMd5(senhaAdm);
    }

}
