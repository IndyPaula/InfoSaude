//package br.edu.ifpb.monteiro.ads.infosaude.dao;
//
//import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
//import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
//import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
//import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.EntityManager;
//import javax.persistence.RollbackException;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
// * @date 09/06/2015
// */
//public class VacinaDaoTest {
//
//    private static EntityManagerProducer emp;
//    private static EntityManager em;
//    private static VacinaDao vacinaDao;
//
//    public VacinaDaoTest() {
//
//    }
//
//    @Before
//    public void configurarDao() {
//
//        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
//        emp = new EntityManagerProducer("InfoSaudePUTest");
//        em = emp.create();
//
//        vacinaDao = new VacinaDao();
//        //SETANTO ENTITY MANAGER MANUALMENTE
//        vacinaDao.setEntityManager(em);
//
//    }
//
//    @After
//    public void limpaEntityManager() {
//
//        vacinaDao.getEntityManager().clear();
//
//    }
//
//    @AfterClass
//    public static void removerTest() {
//
//        try {
//            Vacina vacina = vacinaDao.buscarPorCampo("nome", "123");
//            vacinaDao.remover(vacina);
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Test
//    public void salvarTest() {
//
//        Vacina vacina1 = new Vacina();
//        vacina1.setContraIndicacoes("123");
//        vacina1.setDataFabricacao(new Date());
//        vacina1.setDataVencimento(new Date());
//        vacina1.setId(Long.MIN_VALUE);
//        vacina1.setInstrucaoAdministracao("123");
//        vacina1.setInstrucaoArmazenamento("123");
//        vacina1.setLaboratorio("123");
//        vacina1.setLote("123");
//        vacina1.setNome("123");
//        vacina1.setQuantidadeDoses(3);
//        vacina1.setReacoesAdversas("123");
//        vacina1.setViaAdministracao(EnumViaAdministracao.ORAL);
//
//        try {
//            vacinaDao.getEntityManager().getTransaction().begin();
//            vacinaDao.salvar(vacina1);
//            vacinaDao.getEntityManager().getTransaction().commit();
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Vacina result = new Vacina();
//
//        try {
//            result = vacinaDao.buscarPorCampo("nome", "123");
//
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        assertEquals(vacina1.getId(), result.getId());
//
//    }
//
//    @Test(expected = RollbackException.class)
//    public void loteDuplicadoTest() {
//
//        Vacina vacina = new Vacina();
//        vacina.setContraIndicacoes("123");
//        vacina.setDataFabricacao(new Date());
//        vacina.setDataVencimento(new Date());
//        vacina.setId(Long.MIN_VALUE);
//        vacina.setInstrucaoAdministracao("123");
//        vacina.setInstrucaoArmazenamento("123");
//        vacina.setLaboratorio("123");
//        vacina.setLote("123");
//        vacina.setNome("123");
//        vacina.setQuantidadeDoses(3);
//        vacina.setReacoesAdversas("123");
//        vacina.setViaAdministracao(EnumViaAdministracao.ORAL);
//
//        try {
//            vacinaDao.getEntityManager().getTransaction().begin();
//            vacinaDao.salvar(vacina);
//        } catch (DaoExcecoes ex) {
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Vacina vacina2 = new Vacina();
//        vacina2.setContraIndicacoes("1234");
//        vacina2.setDataFabricacao(new Date());
//        vacina2.setDataVencimento(new Date());
//        vacina2.setId(Long.MIN_VALUE);
//        vacina2.setInstrucaoAdministracao("1234");
//        vacina2.setInstrucaoArmazenamento("1234");
//        vacina2.setLaboratorio("1234");
//        vacina2.setLote("123");
//        vacina2.setNome("1234");
//        vacina2.setQuantidadeDoses(34);
//        vacina2.setReacoesAdversas("1234");
//        vacina2.setViaAdministracao(EnumViaAdministracao.ORAL);
//
//        boolean salvo = true;
//
//        try {
//            vacinaDao.salvar(vacina2);
//            vacinaDao.getEntityManager().getTransaction().commit();
//        } catch (DaoExcecoes ex) {
//
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, "Erro ao Salvar Vacina" + ex);
//            salvo = false;
//        }
//        assertEquals(false, salvo);
//    }
//
//    @Test
//    public void atualizarTest() {
//        Vacina vacina3 = new Vacina();
//        vacina3.setContraIndicacoes("1235");
//        vacina3.setDataFabricacao(new Date());
//        vacina3.setDataVencimento(new Date());
//        vacina3.setId(4567895L);
//        vacina3.setInstrucaoAdministracao("1235");
//        vacina3.setInstrucaoArmazenamento("1235");
//        vacina3.setLaboratorio("1235");
//        vacina3.setLote("1235");
//        vacina3.setNome("1235");
//        vacina3.setQuantidadeDoses(35);
//        vacina3.setReacoesAdversas("1235");
//        vacina3.setViaAdministracao(EnumViaAdministracao.ORAL);
//
//        Vacina test = null;
//
//        try {
//            vacinaDao.getEntityManager().getTransaction().begin();
//            vacinaDao.salvar(vacina3);
//
//            Vacina vacina4 = vacinaDao.consultarPorId(4567895L);
//            vacina4.setNome("1234");
//
//            vacinaDao.atualizar(vacina4);
//            vacinaDao.getEntityManager().getTransaction().commit();
//
//            test = vacinaDao.consultarPorId(4567895L);
//
//        } catch (DaoExcecoes ex) {
//            vacinaDao.getEntityManager().clear();
//            Logger.getLogger(VacinaDaoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        assertEquals(test.getNome(), "1234");
//    }
//
//}
