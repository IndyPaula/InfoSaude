package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vanderlan
 */
public class UnidadeSaudeDaoTest {
    
    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static UnidadeSaudeDao daoUbs ;
    
    public UnidadeSaudeDaoTest() {
        
         //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        
        daoUbs = new UnidadeSaudeDao();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoUbs.setEm(em);
        
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
            daoUbs.salvar(ubs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UnidadeSaude ubs2 = null;
        try {
            daoUbs.getEntityManager().getTransaction().begin();
            ubs2 = daoUbs.buscarPorCampo("numero", 312);
            daoUbs.getEntityManager().getTransaction().commit();
            
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
