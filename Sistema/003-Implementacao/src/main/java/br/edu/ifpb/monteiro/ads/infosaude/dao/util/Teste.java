
package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import br.edu.ifpb.monteiro.ads.infosaude.dao.LoginAdminDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;

/**
 *
 * @author vanderlan
 */
public class Teste {

    public static void main(String[] args) {
        
          
        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm = new LoginAdmin();
        
        adm.setNome("JUNIT-TEST-USER-TO-LOGIN");
        adm.setSenha("202cb962ac59075b964b07152d234b70");
        
        try {
            instance.salvar(adm);
        } catch (DaoExcecoes ex) {
        
            ex.printStackTrace();
        }
    }
}
