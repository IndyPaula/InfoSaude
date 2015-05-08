package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * Criado em 16 de Abril de 2015
 */
public class LoginAdminDaoITest {

    public LoginAdminDaoITest() {

    }

    @BeforeClass
    public static void inserirDados() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm = new LoginAdmin();
        
        UnidadeSaude ubs = new UnidadeSaude();
        ubs.setBairro("efjoewif");
        ubs.setCep("5487598");
        ubs.setCidade("Monteiro");
        ubs.setCnes(4234);
        ubs.setEnderecoNumero(100);
        ubs.setEstado(EnumEstados.PE);
        ubs.setLogradouro("mfioejfie");
        ubs.setNome("UBS 08");
        ubs.setNumero(312);
        
        UnidadeSaudeDao daoUbs = new UnidadeSaudeDao();
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
        adm.setLogin("vanderlan");
        adm.setSenhaAdm("123");
        adm.setSenha("fjhewiufhew");
        adm.setNomeUsuario("fhguwegyf");
        

        try {
            instance.salvar(adm);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void removerDados() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm;

        try {
            adm = instance.buscarPorCampo("login", "vanderlan");
            instance.remover(adm);

        } catch (DaoExcecoes ex) {
            Logger.getLogger(LoginAdminDaoITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void senhaNull() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("admin", null);

        assertEquals(expResult, result);
    }

    @Test
    public void senhaIncorreta() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("vanderlan", "irh328rhf8hh");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioInexistente() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = null;
        LoginAdmin result = instance.efetuarLogin("UT76rg32rghu", "admin");

        assertEquals(expResult, result);
    }

    @Test
    public void usuarioValido() {

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin expResult = new LoginAdmin();
        expResult.setLogin("vanderlan");

        LoginAdmin result = instance.efetuarLogin("vanderlan", "123");

        assertEquals(expResult.getLogin(), result.getLogin());
    }
}
