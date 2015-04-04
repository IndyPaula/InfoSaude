/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.Dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.GenericoDao;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public class DaoGenericoTest {
    
    public DaoGenericoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEM method, of class GenericoDao.
     */
    @org.junit.Test
    public void testGetEM() {
        System.out.println("getEM");
        GenericoDao instance = new DaoGenericoImpl();
        EntityManager expResult = null;
        EntityManager result = instance.getEM();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class GenericoDao.
     */
    @org.junit.Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Object identificadorGenerico = null;
        GenericoDao instance = new DaoGenericoImpl();
        Boolean expResult = null;
        Boolean result = instance.salvar(identificadorGenerico);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class GenericoDao.
     */
    @org.junit.Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        Object identificadorGenerico = null;
        GenericoDao instance = new DaoGenericoImpl();
        Boolean expResult = null;
        Boolean result = instance.atualizar(identificadorGenerico);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of remover method, of class GenericoDao.
     */
    @org.junit.Test
    public void testRemover() {
        System.out.println("remover");
        GenericoDao instance = new DaoGenericoImpl();
        Boolean expResult = null;
        Boolean result = instance.remover(null);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorId method, of class GenericoDao.
     */
    @org.junit.Test
    public void testConsultarPorId() {
        System.out.println("consultarPorId");
        GenericoDao instance = new DaoGenericoImpl();
        Object expResult = null;
        Object result = instance.consultarPorId(null);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public class DaoGenericoImpl extends GenericoDao {
    }
    
}
