package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes
 * @date 21/05/2015
 */
public class UnidadeSaudeDaoTest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static UnidadeSaudeDao daoUbs;

    public UnidadeSaudeDaoTest() {

    }

    @Before
    public  void configurarDao() {

        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();

        daoUbs = new UnidadeSaudeDao();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoUbs.setEntityManager(em);

    }

    @After
    public void limpaEntityManager() {

        daoUbs.getEntityManager().clear();

    }

    @AfterClass
    public static void removerDados() {

        try {
            UnidadeSaude ubs = daoUbs.buscarPorCampo("cnes", 312);

            if (!daoUbs.getEntityManager().getTransaction().isActive()) {
                daoUbs.getEntityManager().getTransaction().begin();
            }
            daoUbs.remover(ubs);
            daoUbs.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void ubsValida() {

        UnidadeSaude ubs = new UnidadeSaude();
        ubs.setBairro("efjoewif");
        ubs.setCep("5487598");
        ubs.setCidade("Monteiro");
        ubs.setCnes(312);
        ubs.setEnderecoNumero(100);
        ubs.setEstado(EnumEstados.PE);
        ubs.setLogradouro("mfioejfie");
        ubs.setNome("UBS 08");
        ubs.setNumero(12);

        try {
            daoUbs.getEntityManager().getTransaction().begin();
            daoUbs.salvar(ubs);
            daoUbs.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UnidadeSaude result = null;
        try {
            daoUbs.getEntityManager().getTransaction().begin();
            result = daoUbs.buscarPorCampo("cnes", 312);
            daoUbs.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(312, result.getCnes());

    }

    @Test
    public void ubsDuplicada() {
        
        UnidadeSaude ubs = new UnidadeSaude();
        ubs.setBairro("Centro");
        ubs.setCep("1244");
        ubs.setCidade("Monteiro");
        ubs.setCnes(310902);
        ubs.setEnderecoNumero(1200);
        ubs.setEstado(EnumEstados.PE);
        ubs.setLogradouro("Av Principal");
        ubs.setNome("UBS 08");
        ubs.setNumero(128);

        try {
            daoUbs.getEntityManager().getTransaction().begin();
            daoUbs.salvar(ubs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }

        UnidadeSaude ubs2 = new UnidadeSaude();
        ubs2.setBairro("Centro");
        ubs2.setCep("1244");
        ubs2.setCidade("Monteiro");
        ubs2.setCnes(310902);
        ubs2.setEnderecoNumero(1200);
        ubs2.setEstado(EnumEstados.PB);
        ubs2.setLogradouro("Av. Principal");
        ubs2.setNome("UBS 08");
        ubs2.setNumero(128);

        boolean salvo = true;

        try {
            daoUbs.salvar(ubs2);
            daoUbs.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {

            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, "Erro ao Salvar UBS" + ex);
            salvo = false;
        }
        assertEquals(false, salvo);
    }

}
