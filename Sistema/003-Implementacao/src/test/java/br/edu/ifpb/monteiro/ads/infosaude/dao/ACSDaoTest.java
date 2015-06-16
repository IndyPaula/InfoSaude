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
import javax.persistence.NoResultException;
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

    @Test(expected = NoResultException.class)
    public void testVerificaCamposUnique() throws DaoExcecoes {

        daoACS.verificaCampoUnique("matricula", 7589327, null);

    }

    @Test(expected = DaoExcecoes.class)
    public void testVerificaCampoUnique() throws DaoExcecoes {

        ACS testCampoUniqueAcs = new ACS();

        testCampoUniqueAcs.setCpf("10188846611");
        testCampoUniqueAcs.setNome("Ze");
        testCampoUniqueAcs.setDataNascimento(new Date());
        testCampoUniqueAcs.setMatricula(13);
        testCampoUniqueAcs.setNumeroArea(432);
        testCampoUniqueAcs.setCartaosus("123453333987654");
        testCampoUniqueAcs.setLogin("Acs Test");
        testCampoUniqueAcs.setSenha("fjosijfew9urj3");
        testCampoUniqueAcs.setCodigoEquipeINE("13234");

        ACS testCpfDuplicadoAcs = new ACS();

        testCpfDuplicadoAcs.setCpf("10199946610");
        testCpfDuplicadoAcs.setNome("Ze Segundo");
        testCpfDuplicadoAcs.setDataNascimento(new Date());
        testCpfDuplicadoAcs.setMatricula(88899901);
        testCpfDuplicadoAcs.setNumeroArea(321);
        testCpfDuplicadoAcs.setCartaosus("123459999987611");
        testCpfDuplicadoAcs.setLogin("Acs test");
        testCpfDuplicadoAcs.setSenha("fjosijfew9urj3");
        testCpfDuplicadoAcs.setCodigoEquipeINE("13234");

        ACS a = null;

        daoACS.getEntityManager().getTransaction().begin();
        daoACS.salvar(testCampoUniqueAcs);
        daoACS.salvar(testCpfDuplicadoAcs);
        daoACS.getEntityManager().getTransaction().commit();

        a = daoACS.buscarPorCampo("cpf", testCpfDuplicadoAcs.getCpf());
        a.setMatricula(13);
        daoACS.verificaCampoUnique("matricula", testCampoUniqueAcs.getMatricula(), a.getId());
    }

    @Test
    public void testACSValido() {

        ACS agente = new ACS();
        agente.setCartaosus("53453843234");
        agente.setNome("Vanderlan Gomes da Silva");
        agente.setCpf("60945473422");
        agente.setNumeroArea(329);
        agente.setMatricula(35659087);
        agente.setLogin("ACS2");
        agente.setCodigoEquipeINE("5434552");
        agente.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        agente.setDataNascimento(new Date());
        agente.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(agente);
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
        assertEquals(agente.getId(), result.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testCpfNull() {
        ACS agenteComunitario = new ACS();
        agenteComunitario.setCartaosus("534534534");
        agenteComunitario.setNome("Fulano Alves");
        agenteComunitario.setDataNascimento(new Date());
        agenteComunitario.setSexo(EnumGeneros.MASCULINO);

        boolean validadation = true;

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(agenteComunitario);
            daoACS.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {

            Logger.getLogger(ACSDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(false, validadation);
    }

    @Test
    public void testEdicao() {

        ACS agenteComunitarioSaude = new ACS();
        agenteComunitarioSaude.setCartaosus("99894325252");
        agenteComunitarioSaude.setNome("Ze Agente");
        agenteComunitarioSaude.setCpf("43254357631");
        agenteComunitarioSaude.setDataNascimento(new Date());
        agenteComunitarioSaude.setSexo(EnumGeneros.MASCULINO);
        agenteComunitarioSaude.setCodigoEquipeINE("5439");
        agenteComunitarioSaude.setSenha(CriptografiaUtil.convertStringToMd5("534543"));
        agenteComunitarioSaude.setLogin("Ze");
        agenteComunitarioSaude.setEstado(EnumEstados.PE);
        agenteComunitarioSaude.setNumeroArea(12);
        agenteComunitarioSaude.setMatricula(124);

        ACS result = null;
        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(agenteComunitarioSaude);

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

        ACS acsTestRemove = new ACS();
        acsTestRemove.setCartaosus("756382915734027");
        acsTestRemove.setNome("Maria Agente");
        acsTestRemove.setCpf("38563710983");
        acsTestRemove.setDataNascimento(new Date());
        acsTestRemove.setSexo(EnumGeneros.FEMININO);
        acsTestRemove.setCodigoEquipeINE("9130");
        acsTestRemove.setMatricula(535432121);
        acsTestRemove.setSenha(CriptografiaUtil.convertStringToMd5("1543"));
        acsTestRemove.setLogin("Mary");
        acsTestRemove.setEstado(EnumEstados.PA);
        acsTestRemove.setNumeroArea(12);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acsTestRemove);
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

        ACS acsVerificaUnique = new ACS();
        acsVerificaUnique.setCartaosus("11153843234");
        acsVerificaUnique.setNome("Vanderlan Gomes da Silva");
        acsVerificaUnique.setCpf("60111473422");
        acsVerificaUnique.setNumeroArea(19);
        acsVerificaUnique.setMatricula(35611117);
        acsVerificaUnique.setLogin("ACS3");
        acsVerificaUnique.setCodigoEquipeINE("5414552");
        acsVerificaUnique.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        acsVerificaUnique.setDataNascimento(new Date());
        acsVerificaUnique.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acsVerificaUnique);
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

        ACS acs4 = new ACS();
        acs4.setCartaosus("11153843231");
        acs4.setNome("Vanderlan Gomes da Silva");
        acs4.setCpf("60111473421");
        acs4.setNumeroArea(19);
        acs4.setMatricula(35611111);
        acs4.setLogin("ACS4");
        acs4.setCodigoEquipeINE("5414559");
        acs4.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
        acs4.setDataNascimento(new Date());
        acs4.setSexo(EnumGeneros.MASCULINO);

        try {

            daoACS.getEntityManager().getTransaction().begin();
            daoACS.salvar(acs4);
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
