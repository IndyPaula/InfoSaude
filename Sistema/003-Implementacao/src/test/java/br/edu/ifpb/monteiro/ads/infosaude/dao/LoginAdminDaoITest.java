package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * Criado em 16 de Abril de 2015
 */
public class LoginAdminDaoITest {

    public LoginAdminDaoITest() {

    }

    @BeforeClass
    public static void inserirDados() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm = new LoginAdmin();

        adm.setLogin("JUNIT-TEST-USER-TO-LOGIN");
        adm.setSenha("202cb962ac59075b964b07152d234b70");

        try {
            instance.salvar(adm);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void removerDados() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm;

        try {
            adm = instance.buscarPorCampo("login", "JUNIT-TEST-USER-TO-LOGIN");
            instance.remover(adm);

        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void senhaNull() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("admin", null);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaIncorreta() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("JUNIT-TEST-USER-TO-LOGIN", "irh328rhf8hh");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioInexistente() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("UT76rg32rghu", "admin");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioValido() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = new LoginAdmin();
        expResult.setLogin("JUNIT-TEST-USER-TO-LOGIN");

        LoginAdmin result = instance.efetuarLogin("JUNIT-TEST-USER-TO-LOGIN", "202cb962ac59075b964b07152d234b70");

        assertEquals(expResult.getLogin(), result.getLogin());
    }
}
