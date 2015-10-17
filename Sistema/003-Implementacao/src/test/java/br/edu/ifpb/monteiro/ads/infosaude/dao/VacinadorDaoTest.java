//package br.edu.ifpb.monteiro.ads.infosaude.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
//import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
//import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
//import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
//import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
//import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
//import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.EntityManager;
//import javax.validation.ConstraintViolationException;
//import org.junit.After;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// *
// * @author Vanderlan Gomes
// * @date 30/05/2015
// */
//public class VacinadorDaoTest {
//
//    private static EntityManagerProducer emp;
//    private static EntityManager em;
//    private static VacinadorDao daoVacinador;
//    private static LoginDao daoLogin;
//
//    @Before
//    public void preparaDados() {
//        daoVacinador = new VacinadorDao();
//        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
//        emp = new EntityManagerProducer("InfoSaudePUTest");
//        em = emp.create();
//        //SETANTO ENTITY MANAGER MANUALMENTE
//        daoVacinador.setEntityManager(em);
//
//        daoLogin = new LoginDao();
//        daoLogin.setEntityManager(em);
//
//    }
//
//    public void testVerificaCamposUnique() throws DaoExcecoes {
//
//        daoVacinador.verificaCampoUnique("cpf", "17469865382", null);
//
//    }
//
//    @Test(expected = DaoExcecoes.class)
//    public void testVerificaCampoUnique() throws DaoExcecoes {
//
//        Vacinador testCampoUnique = new Vacinador();
//
//        testCampoUnique.setCpf("10125346611");
//        testCampoUnique.setNome("Ze");
//        testCampoUnique.setDataNascimento(new Date());
//        testCampoUnique.setMatricula(8884324);
//        testCampoUnique.setCoren(9857349);
//        testCampoUnique.setCartaosus("123451111987654");
//        testCampoUnique.setLogin("AAA");
//        testCampoUnique.setSenha("fjosijfew9urj3");
//        testCampoUnique.setCodigoEquipeINE("13234");
//
//        Vacinador testCpfDuplicado = new Vacinador();
//
//        testCpfDuplicado.setCpf("10199946611");
//        testCpfDuplicado.setNome("Ze Segundo");
//        testCpfDuplicado.setDataNascimento(new Date());
//        testCpfDuplicado.setMatricula(888999);
//        testCpfDuplicado.setCoren(985734921);
//        testCpfDuplicado.setCartaosus("123459999987654");
//        testCpfDuplicado.setLogin("BBB");
//        testCpfDuplicado.setSenha("fjosijfew9urj3");
//        testCpfDuplicado.setCodigoEquipeINE("13234");
//
//        Vacinador va = null;
//
//        daoVacinador.getEntityManager().getTransaction().begin();
//        daoVacinador.salvar(testCampoUnique);
//        daoVacinador.salvar(testCpfDuplicado);
//        daoVacinador.getEntityManager().getTransaction().commit();
//
//        va = daoVacinador.buscarPorCampo("cpf", testCpfDuplicado.getCpf());
//        va.setCpf("10125346611");
//        daoVacinador.verificaCampoUnique("cpf", testCampoUnique.getCpf(), va.getId());
//    }
//
//    @Test
//    public void testDadosValidos() {
//
//        Vacinador vac = new Vacinador();
//
//        vac.setNome("InfoSaude");
//        vac.setCpf("111.293.324-23");
//        vac.setDataNascimento(new Date());
//        vac.setMatricula(12432);
//        vac.setCoren(8748);
//        vac.setLogin("Joelton");
//        vac.setCartaosus("123435436546");
//        vac.setSenha("456");
//        vac.setCodigoEquipeINE("487");
//        vac.setNomeMae("Maria");
//        vac.setNomePai("José");
//        vac.setEtnia(EnumEtnias.PARDO);
//        vac.setAltura(1.9);
//        vac.setPeso(95);
//        vac.setPesoNascer(3.6);
//        vac.setNumero(42);
//        vac.setRg("89898");
//        vac.setOrgaoEmissor("SDS");
//        vac.setUfOrgaoEmissor(EnumEstados.PI);
//
//        vac.equals(vac);
//
//        Vacinador result = null;
//        try {
//            daoVacinador.getEntityManager().getTransaction().begin();
//            daoVacinador.salvar(vac);
//            daoVacinador.getEntityManager().getTransaction().commit();
//
//            result = daoVacinador.buscarPorCampo("cpf", vac.getCpf());
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Integer a = 12432;
//        assertEquals(a, result.getMatricula());
//    }
//
//    @After
//    public void limpaEntityManager() {
//
//        daoVacinador.getEntityManager().clear();
//
//    }
//
//    @Test(expected = ConstraintViolationException.class)
//    public void testCpfInvalido() {
//
//        Vacinador vacinadorTestCpf = new Vacinador();
//
//        vacinadorTestCpf.setNome("InfoSaude");
//        vacinadorTestCpf.setDataNascimento(new Date());
//        vacinadorTestCpf.setMatricula(432432);
//        vacinadorTestCpf.setCoren(423423);
//        vacinadorTestCpf.setLogin("InfoSaude");
//        vacinadorTestCpf.setSenha("fjosijfew9urj3");
//        vacinadorTestCpf.setCodigoEquipeINE("4234");
//
//        try {
//            daoVacinador.getEntityManager().getTransaction().begin();
//            daoVacinador.salvar(vacinadorTestCpf);
//            daoVacinador.getEntityManager().getTransaction().commit();
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Test
//    public void testRemocao() {
//
//        inserirRegistro();
//        Vacinador v = null;
//        try {
//
//            v = daoVacinador.buscarPorCampo("cpf", "101.523.466-99");
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        daoVacinador.getEntityManager().getTransaction().begin();
//        daoVacinador.remover(v);
//
//        Vacinador v2 = null;
//        try {
//
//            v2 = daoVacinador.buscarPorCampo("cpf", "101.523.466-99");
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        assertEquals(v2, null);
//
//    }
//
//    public void inserirRegistro() {
//
//        Vacinador vInsert = new Vacinador();
//
//        vInsert.setCpf("101.523.466-99");
//        vInsert.setNome("InfoSaude");
//        vInsert.setDataNascimento(new Date());
//        vInsert.setMatricula(7777);
//        vInsert.setCoren(102030);
//        vInsert.setCartaosus("123456789987654");
//        vInsert.setLogin("Teste");
//        vInsert.setSenha("fjosijfew9urj3");
//        vInsert.setCodigoEquipeINE("41343234");
//
//        try {
//            daoVacinador.getEntityManager().getTransaction().begin();
//            daoVacinador.salvar(vInsert);
//            daoVacinador.getEntityManager().getTransaction().commit();
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Test
//    public void testVerificaCampoUniqueCadastro() {
//
//        Vacinador testCampoUnique = new Vacinador();
//        testCampoUnique.setCartaosus("11153822234");
//        testCampoUnique.setNome("Vanderlan Gomes da Silva");
//        testCampoUnique.setCpf("60111223422");
//        testCampoUnique.setCoren(16439);
//        testCampoUnique.setMatricula(35612217);
//        testCampoUnique.setLogin("Vacinador3");
//        testCampoUnique.setCodigoEquipeINE("5414552");
//        testCampoUnique.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
//        testCampoUnique.setDataNascimento(new Date());
//        testCampoUnique.setSexo(EnumGeneros.MASCULINO);
//
//        try {
//
//            daoVacinador.getEntityManager().getTransaction().begin();
//            daoVacinador.salvar(testCampoUnique);
//            daoVacinador.getEntityManager().getTransaction().commit();
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        boolean result;
//        try {
//
//            result = daoVacinador.verificaCampoUnique("cpf", "60111223422", null);
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//            result = false;
//        }
//        assertEquals(result, false);
//    }
//
//    @Test(expected = DaoExcecoes.class)
//    public void testVerificaCampoUniqueEdicao() throws DaoExcecoes {
//
//        Vacinador vac = new Vacinador();
//        vac.setCartaosus("11153822231");
//        vac.setNome("Vanderlan Gomes da Silva");
//        vac.setCpf("60111223421");
//        vac.setCoren(59793);
//        vac.setMatricula(356126111);
//        vac.setLogin("Vacinador4");
//        vac.setCodigoEquipeINE("5414559");
//        vac.setSenha(CriptografiaUtil.convertStringToMd5("10042991"));
//        vac.setDataNascimento(new Date());
//        vac.setSexo(EnumGeneros.MASCULINO);
//
//        try {
//
//            daoVacinador.getEntityManager().getTransaction().begin();
//            daoVacinador.salvar(vac);
//            daoVacinador.getEntityManager().getTransaction().commit();
//
//            daoVacinador.setEntity(Vacinador.class);
//            daoVacinador.getEntity();
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Vacinador result;
//        boolean resultado;
//        try {
//
//            result = daoVacinador.buscarPorCampo("cpf", "60111223421");
//            resultado = daoVacinador.verificaCampoUnique("cpf", "60111223421", result.getId());
//
//        } catch (DaoExcecoes ex) {
//            resultado = false;
//            Logger.getLogger(VacinadorDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        if (resultado) {
//            throw new DaoExcecoes("Já existe", new Throwable());
//        }
//    }
//}
