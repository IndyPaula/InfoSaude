package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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

    @BeforeClass
    public static void configurarDao() {

        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();

        daoUbs = new UnidadeSaudeDao();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoUbs.setEntityManager(em);

    }

    @AfterClass
    public static void removerDados() {

        try {
            UnidadeSaude ubs = daoUbs.buscarPorCampo("cnes", 312);

            daoUbs.getEntityManager().getTransaction().begin();
            daoUbs.remover(ubs);
            daoUbs.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
            Logger.getLogger(LoginAdminDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UnidadeSaude result = null;
        try {
            daoUbs.getEntityManager().getTransaction().begin();
            result = daoUbs.buscarPorCampo("cnes", 312);
            daoUbs.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void ubsCnesDuplicado() {

        ubsValida();
        
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

        boolean salvo = true;

        try {
            daoUbs.getEntityManager().getTransaction().begin();
            daoUbs.salvar(ubs);
            daoUbs.getEntityManager().getTransaction().commit();
        } catch (javax.persistence.RollbackException ex) {
            
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).
                    log(Level.SEVERE, null, "Erro ao salvar UBS - CNES já existe");
            salvo = false;

        } catch (DaoExcecoes ex) {

            Logger.getLogger(LoginAdminDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(false, salvo);
    }

}