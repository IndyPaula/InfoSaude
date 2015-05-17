package br.edu.ifpb.monteiro.ads.infosaude.service;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 */
public class LoginAdminServiceTest {

    private static LoginAdminService service;
    
    public LoginAdminServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    
        service = new LoginAdminService();
        
    }
    

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of efetuarLogin method, of class LoginAdminService.
     */
    @Test
    public void loginSenhaNulo() {

        assertEquals(null, service.efetuarLogin(null, null));
    }
    
    @Test
    public void loginSenhaValidos() {

        assertEquals(null, service.efetuarLogin("Vanderlan", "123"));
    }
}
