package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes
 * @date 20/05/2015
 */
public class PacienteDaoTest {
    
    
    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static PacienteDao daoPaciente;
    
    
    public PacienteDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        daoPaciente = new PacienteDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoPaciente.setEm(em);
    }
    
    @Before
    public  void setUpMethod() {
        
        daoPaciente.getEntityManager().getTransaction().begin();
        daoPaciente.getEntityManager().createNativeQuery("DELETE FROM paciente").executeUpdate();
        daoPaciente.getEntityManager().createNativeQuery("DELETE FROM pessoa").executeUpdate();
          
        daoPaciente.getEntityManager().getTransaction().commit();
    }

    @Test
    public void testPacienteValido() {
        
        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("534534534");
        paciente.setNome("Vanderlan Gomes da Silva");
        paciente.setCpf("10145473422");
        paciente.setDataNascimento(new Date(1993, 04, 01));
        paciente.setNumeroProntuario(4234);
        paciente.setDataCadastro(new Date());
        paciente.setSexo(EnumGeneros.MASCULINO);
        
        try {
            
            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente);
            daoPaciente.getEntityManager().getTransaction().commit();
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Paciente result = new Paciente();
        try {
             result = daoPaciente.buscarPorCampo("cpf", "10145473422");
             
        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(paciente.getId(), result.getId());
    }
    
     public void testCpfNull() {
        
        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("534534534");
        paciente.setNome("Fulano Alves");
        paciente.setDataNascimento(new Date(1993, 04, 01));
        paciente.setNumeroProntuario(4234);
        paciente.setDataCadastro(new Date());
        paciente.setSexo(EnumGeneros.MASCULINO);
        
        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente);
            daoPaciente.getEntityManager().getTransaction().commit();
             System.out.println("SAVE");
            
        } catch (RollbackException|DaoExcecoes ex) {
            
             Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        Paciente result = null;
        try {
             result = daoPaciente.buscarPorCampo("nome", "Fulano Alves");
             
        } catch (DaoExcecoes ex) {
            
           Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        assertEquals(null, result);
    }
    
   
     public void testCpfDuplicado() {
        
        boolean salvo = false;
        
        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("95134534");
        paciente.setNome("Vanderlan Gomes da Silva");
        paciente.setCpf("86745264871");
        paciente.setDataNascimento(new Date(1993, 04, 01));
        paciente.setNumeroProntuario(105583498);
        paciente.setDataCadastro(new Date());
        paciente.setSexo(EnumGeneros.MASCULINO);
        
        Paciente paciente2 = new Paciente();
        paciente2.setCartaoSUS("53424534");
        paciente2.setCpf("86745264871");
        paciente2.setNome("Joelton Quirino Brito");
        paciente2.setDataNascimento(new Date(1991, 04, 01));
        paciente2.setNumeroProntuario(9854);
        paciente2.setDataCadastro(new Date());
        paciente2.setSexo(EnumGeneros.MASCULINO);
        
        try {
            
            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente);
            daoPaciente.getEntityManager().getTransaction().commit();
            
        } catch (DaoExcecoes ex) {
            
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        try {
            
            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente2);
            daoPaciente.getEntityManager().getTransaction().commit();
            salvo = true;
            
        } catch (RollbackException|DaoExcecoes ex) {
            
             Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
      
        assertEquals(false, salvo);
    }
    
}