package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.LoginAdminService;
import br.edu.ifpb.monteiro.ads.infosaude.service.UnidadeSaudeService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.LoginAdminServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.UnidadeSaudeServiceIF;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Vanderlan Gomes<123.gs@gmail.com>
 * Criado em 16 de Abril de 2015
 */
public class LoginAdminDaoITest {

//    public LoginAdminDaoITest() {
//
//    }
//
//    @BeforeClass
//    public static void inserirDados() throws ServiceExcecoes {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin adm = new LoginAdmin();
//
//        UnidadeSaude ubs = new UnidadeSaude();
//        ubs.setBairro("efjoewif");
//        ubs.setCep("5487598");
//        ubs.setCidade("Monteiro");
//        ubs.setCnes(4234);
//        ubs.setEnderecoNumero(100);
//        ubs.setEstado(EnumEstados.PE);
//        ubs.setLogradouro("mfioejfie");
//        ubs.setNome("UBS 08");
//        ubs.setNumero(312);
//
//        UnidadeSaudeServiceIF daoUbs = new UnidadeSaudeService();
//        daoUbs.salvar(ubs);
//
//        adm.setUnidadeSaude(ubs);
//        adm.setMatricula(4234);
//        adm.setNome("Vanderlan Gomes");
//        adm.setCpf("101.538.432-32");
//        adm.setDataNascimento(new Date(2015, 5, 1));
//        adm.setCodigoEquipeINE("2423432");
//        adm.setLogin("123");
//        adm.setSenhaAdm("123");
//        adm.setSenha("fjhewiufhew");
//        adm.setNomeUsuario("fhguwegyf");
//
//        instance.salvar(adm);
//    }
//
//    @AfterClass
//    public static void removerDados() throws ServiceExcecoes {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin adm;
//
//        adm = instance.buscarPorCampo("login", "123");
//    }
//
//    @Test
//    public void senhaNull() {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin expResult = null;
//        LoginAdmin result = instance.efetuarLogin("admin", null);
//
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void senhaIncorreta() {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin expResult = null;
//        LoginAdmin result = instance.efetuarLogin("123", "irh328rhf8hh");
//
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void usuarioInexistente() {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin expResult = null;
//        LoginAdmin result = instance.efetuarLogin("UT76rg32rghu", "admin");
//
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void usuarioValido() {
//
//        LoginAdminServiceIF instance = new LoginAdminService();
//        LoginAdmin expResult = new LoginAdmin();
//        expResult.setLogin("123");
//
//        LoginAdmin result = instance.efetuarLogin("123", "123");
//
//        assertEquals(expResult.getLogin(), result.getLogin());
//    }
}
