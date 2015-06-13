package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes
 * @date 30/05/2015
 */
public class LoginDaoTest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static VacinadorDao daoVacinador;
    private static ACSDao daoAcs;
    private static LoginDao daoLogin;

    @BeforeClass
    public static void preparaDados() {
        daoVacinador = new VacinadorDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoVacinador.setEntityManager(em);

        daoLogin = new LoginDao();
        daoLogin.setEntityManager(em);

        Vacinador v = new Vacinador();

        v.setNome("InfoSaude");
        v.setCpf("111.233.324-23");
        v.setDataNascimento(new Date());
        v.setMatricula(432432);
        v.setCoren(423423);
        v.setLogin("InfoSaude");
        v.setCartaoSUS("987623433223443");
        v.setSenha(CriptografiaUtil.convertStringToMd5("12345"));
        v.setCodigoEquipeINE("4234");
        v.setAdm("s");

        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();
            inserirAcs();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void inserirAcs(){
        
        ACS acs = new ACS();

        acs.setNome("InfoSaude");
        acs.setCpf("98745328712");
        acs.setDataNascimento(new Date());
        acs.setMatricula(958734983);
        acs.setNumeroArea(2);
        acs.setLogin("acsLogin");
        acs.setCartaoSUS("127593754739264");
        acs.setSenha(CriptografiaUtil.convertStringToMd5("123"));
        acs.setCodigoEquipeINE("42987123");
        acs.setAdm("s");
        
        
        daoAcs = new ACSDao();
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        daoAcs.setEntityManager(em);

        try {
            daoAcs.getEntityManager().getTransaction().begin();
            daoAcs.salvar(acs);
            daoAcs.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Test
    public void tesUsuarioSenhaInvalido() {

        Vacinador result = (Vacinador) daoLogin.efetuarLogin(null, null);

        assertEquals(null, result);
    }

    @Test
    public void tesUsuarioValidoSenhaNull() {

        Vacinador result = (Vacinador) daoLogin.efetuarLogin("InfoSaude", null);

        assertEquals(null, result);
    }

    @Test
    public void tesUsuarioValidoSenhaIncorreta() {

        Vacinador result = (Vacinador) daoLogin.efetuarLogin("InfoSaude", "32r8932r8932y");

        assertEquals(null, result);
    }

    @Test
    public void tesUsuarioValidoSenhaValidaVacinador() {

        Vacinador result = (Vacinador) daoLogin.efetuarLogin("InfoSaude","12345");

        assertEquals("111.233.324-23", result.getCpf());
    }
    
    @Test
    public void tesUsuarioValidoSenhaValidaAcs() {

        ACS result = (ACS) daoLogin.efetuarLogin("acsLogin","123");

        assertEquals("98745328712", result.getCpf());
    }

    @Test
    public void tesUsuarioSenhaIncorretos() {

        Vacinador result = (Vacinador) daoLogin.efetuarLogin("User", "8389ueçfjfwe");

        assertEquals(null, result);
    }
    
    @AfterClass
    public static void limparDados(){
        
        try {
            Vacinador v = daoVacinador.buscarPorCampo("cpf", "111.233.324-23");
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.remover(v);
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
