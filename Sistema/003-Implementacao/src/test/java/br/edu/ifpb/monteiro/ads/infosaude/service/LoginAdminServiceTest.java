package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.LoginAdminDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 */
public class LoginAdminServiceTest {

    private static LoginAdminService service;

    private LoginAdmin adm;
    
    @Mock
    private LoginAdminDaoIF dao;

    public LoginAdminServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        service = new LoginAdminService();

    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        adm = new LoginAdmin();
        adm.setLogin("User");
        adm.setSenhaAdm("123456");
        
        when(dao.efetuarLogin("User", "123456")).thenReturn(adm);
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

        adm = new LoginAdmin();
        adm.setLogin("User");
        adm.setSenhaAdm("123456");
        
        when(dao.efetuarLogin("User", "123456")).thenReturn(adm);

        LoginAdmin admResult = dao.efetuarLogin("User", "123456");
        
        assertEquals(adm.getLogin(), admResult.getLogin());
    }
    
    @Test
    public void senhaInvalida() {

        LoginAdmin admResult = dao.efetuarLogin("User", "123");
        
        assertEquals(null, admResult);
    }
}
