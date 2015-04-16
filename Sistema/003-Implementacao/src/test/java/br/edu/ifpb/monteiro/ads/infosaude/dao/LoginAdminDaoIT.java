package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * Criado em 16 de Abril de 2015
 */
public class LoginAdminDaoIT {

    public LoginAdminDaoIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of efetuarLogin method, of class LoginAdminDao.
     */
    @Test
    public void senhaNull() {
        System.out.println("Teste de Senha Null");

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("Vanderlan", null);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaIncorreta() {
        System.out.println("Teste de Senha incorreta");

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("Vanderlan", "irh328rhf8hh");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioInexistente() {
        System.out.println("Teste de usuários inexistente");

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("UT76rg32rghu", "dwqf");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioValido() {
        System.out.println("Teste de usuário válido");

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = new LoginAdmin();
        expResult.setNome("Vanderlan");

        LoginAdmin result = instance.efetuarLogin("Vanderlan", "123");

        assertEquals(expResult.getNome(), result.getNome());
    }
}