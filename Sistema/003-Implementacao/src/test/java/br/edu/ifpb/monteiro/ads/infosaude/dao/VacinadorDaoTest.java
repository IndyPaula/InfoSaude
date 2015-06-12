package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes
 * @date 30/05/2015
 */
public class VacinadorDaoTest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static VacinadorDao daoVacinador;
    private static LoginDao daoLogin;

    @Before
    public void preparaDados() {
        daoVacinador = new VacinadorDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoVacinador.setEntityManager(em);

        daoLogin = new LoginDao();
        daoLogin.setEntityManager(em);

    }

    @Test
    public void testDadosValidos() {

        Vacinador v = new Vacinador();

        v.setNome("InfoSaude");
        v.setCpf("111.293.324-23");
        v.setDataNascimento(new Date());
        v.setMatricula(12432);
        v.setCoren(8748);
        v.setLogin("Joelton");
        v.setCartaoSUS("123435436546");
        v.setSenha("456");
        v.setCodigoEquipeINE("487");

        Vacinador result = null;
        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();

            result = daoVacinador.buscarPorCampo("cpf", v.getCpf());
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(12432, result.getMatricula());
    }

    @After
    public void limpaEntityManager() {

        daoVacinador.getEntityManager().clear();

    }

    @Test(expected = ConstraintViolationException.class)
    public void testCpfInvalido() {

        Vacinador v = new Vacinador();

        v.setNome("InfoSaude");
        v.setDataNascimento(new Date());
        v.setMatricula(432432);
        v.setCoren(423423);
        v.setLogin("InfoSaude");
        v.setSenha("fjosijfew9urj3");
        v.setCodigoEquipeINE("4234");

        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testRemocao() {
        
        inserirRegistro();
        Vacinador v = null;
        try {
            
            v = daoVacinador.buscarPorCampo("cpf", "101.523.466-99");
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        daoVacinador.getEntityManager().getTransaction().begin();
        daoVacinador.remover(v);
        
        Vacinador v2 = null;
        try {
            
            v2 = daoVacinador.buscarPorCampo("cpf", "101.523.466-99");
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(v2, null);

    }

    public void inserirRegistro() {

        Vacinador v = new Vacinador();

        v.setCpf("101.523.466-99");
        v.setNome("InfoSaude");
        v.setDataNascimento(new Date());
        v.setMatricula(7777);
        v.setCoren(102030);
        v.setCartaoSUS("123456789987654");
        v.setLogin("Teste");
        v.setSenha("fjosijfew9urj3");
        v.setCodigoEquipeINE("41343234");

        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
