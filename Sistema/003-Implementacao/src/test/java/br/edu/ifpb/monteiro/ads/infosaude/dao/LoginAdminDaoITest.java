package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * Criado em 16 de Abril de 2015
 */
public class LoginAdminDaoITest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static UnidadeSaudeDao daoUbs ;
    private static LoginAdminDao daoAdm;
    
    public LoginAdminDaoITest() {

    }

    @BeforeClass
    public static void inserirDados(){

        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        
        daoUbs = new UnidadeSaudeDao();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoUbs.setEm(em);
        
        LoginAdmin adm = new LoginAdmin();

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

        adm.setUnidadeSaude(ubs);
        adm.setMatricula(4234);
        adm.setNome("Vanderlan Gomes");
        adm.setCpf("101.538.432-32");
        adm.setDataNascimento(new Date(2015, 5, 1));
        adm.setCodigoEquipeINE("2423432");
        adm.setSenha("fjhewiufhew");
        adm.setNomeUsuario("fhguwegyf");
        
        adm.setLogin("user");
        adm.setSenhaAdm("123");
        
        daoAdm = new LoginAdminDao();
        daoAdm.setEm(em);

        try {
            daoAdm.getEm().getTransaction().begin();
            daoAdm.salvar(adm);
            daoAdm.getEm().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void senhaNull() {

        LoginAdmin expResult = null;

        LoginAdmin result = daoAdm.efetuarLogin("admin", null);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaIncorreta() {

        LoginAdmin expResult = null;
        LoginAdmin result = daoAdm.efetuarLogin("123", "irh328rhf8hh");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioInexistente() {

        LoginAdmin expResult = null;
        LoginAdmin result = daoAdm.efetuarLogin("UT76rg32rghu", "admin");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioValido() {

        LoginAdmin expResult = new LoginAdmin();
        expResult.setLogin("user");

        LoginAdmin result = daoAdm.efetuarLogin("user", "123");

        assertEquals(expResult.getLogin(), result.getLogin());
    }
}
