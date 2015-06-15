package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
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
 * @date 20/05/2015
 */
public class ACSDaoTest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static ACSDao daoACS;

    public ACSDaoTest() {

    }

    @Before
    public void preparaDao() {
        daoACS = new ACSDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoACS.setEntityManager(em);

    }

    @After
    public void limpaEntityManager() {

        daoACS.getEntityManager().clear();
    }

    @Test
    public void testACSValido() {

        ACS acs = new ACS();
        acs.setCartaosus("53453843234");
        acs.setNome("Vanderlan Gomes da Silva");
        acs.setCpf("60945473422");
        acs.setNumeroArea(329);
        acs.setMatricula(35659087);
        acs.setLogin("ACS2");
        acs.setCodigoEquipeINE("5434552");
        acs.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);
            daoACS.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACS result = new ACS();
        try {

            result = daoACS.buscarPorCampo("cpf", "60945473422");

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(acs.getId(), result.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCpfNull() {
        ACS acs = new ACS();
        acs.setCartaosus("534534534");
        acs.setNome("Fulano Alves");
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.MASCULINO);

        boolean validadation = true;

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);
            daoACS.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {

            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(false, validadation);
    }

    @Test
    public void testEdicao() {

        ACS acs = new ACS();
        acs.setCartaosus("99894325252");
        acs.setNome("Ze Agente");
        acs.setCpf("43254357631");
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.MASCULINO);
        acs.setCodigoEquipeINE("5439");
        acs.setSenha(CriptografiaUtil.convertStringToMd5("534543"));
        acs.setLogin("Ze");
        acs.setEstado(EnumEstados.PE);
        acs.setNumeroArea(12);
        acs.setMatricula(124);

        ACS result = null;
        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);

            ACS acs2 = daoACS.buscarPorCampo("cpf", "43254357631");
            acs2.setNome("Vanderlan Gomes da Silva");

            daoACS.atualizar(acs2);
            daoACS.getEntityManager().getTransaction().commit();

            result = daoACS.buscarPorCampo("cpf", "43254357631");

        } catch (DaoExcecoes ex) {
            daoACS.getEntityManager().clear();
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(result.getNome(), "Vanderlan Gomes da Silva");
    }

    @Test
    public void testRemocao() {

        ACS acs = new ACS();
        acs.setCartaosus("756382915734027");
        acs.setNome("Maria Agente");
        acs.setCpf("38563710983");
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.FEMININO);
        acs.setCodigoEquipeINE("9130");
        acs.setMatricula(535432121);
        acs.setSenha(CriptografiaUtil.convertStringToMd5("1543"));
        acs.setLogin("Mary");
        acs.setEstado(EnumEstados.PA);
        acs.setNumeroArea(12);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);
            daoACS.getEntityManager().getTransaction().commit();

            ACS acs2 = daoACS.buscarPorCampo("cpf", "38563710983");

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.remover(acs2);

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Test
    public void testVerificaCampoUniqueCadastro() {

        ACS acs = new ACS();
        acs.setCartaosus("11153843234");
        acs.setNome("Vanderlan Gomes da Silva");
        acs.setCpf("60111473422");
        acs.setNumeroArea(19);
        acs.setMatricula(35611117);
        acs.setLogin("ACS3");
        acs.setCodigoEquipeINE("5414552");
        acs.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);
            daoACS.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean result;
        try {

            result = daoACS.verificaCampoUnique("cpf", "60111473422", null);

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        assertEquals(result, false);
    }

    @Test
    public void testVerificaCampoUniqueEdicao() {

        ACS acs = new ACS();
        acs.setCartaosus("11153843231");
        acs.setNome("Vanderlan Gomes da Silva");
        acs.setCpf("60111473421");
        acs.setNumeroArea(19);
        acs.setMatricula(35611111);
        acs.setLogin("ACS4");
        acs.setCodigoEquipeINE("5414559");
        acs.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        acs.setDataNascimento(new Date());
        acs.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs);
            daoACS.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ACS result;
        boolean resultado = false;
        try {

            result = daoACS.buscarPorCampo("cpf", "60111473421");
            resultado = daoACS.verificaCampoUnique("cpf", "60111473421", result.getId());

        } catch (DaoExcecoes ex) {
            resultado = false;
            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
