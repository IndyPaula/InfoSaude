package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
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
 */
public class LoginAdminServiceTest {
    
    public LoginAdminServiceTest() {
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
     * Test of getDao method, of class LoginAdminService.
     */
    @Test
    public void testGetDao() {
        System.out.println("getDao");
        LoginAdminService instance = new LoginAdminService();
        DaoIF expResult = null;
        DaoIF result = instance.getDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of efetuarLogin method, of class LoginAdminService.
     */
    @Test
    public void testEfetuarLogin() {
        System.out.println("efetuarLogin");
        String login = "";
        String senha = "";
        LoginAdminService instance = new LoginAdminService();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
