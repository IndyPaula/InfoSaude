package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriaUsuarios;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vanderlan Gomes
 * @date 30/05/2015
 */
public class VacinadorDaoTest {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static VacinadorDao daoVacinador;
    private static LoginDao daoLogin;

    @BeforeClass
    public static void preparaDados() {
        daoVacinador = new VacinadorDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoVacinador.setEntityManager(em);

        daoLogin = new LoginDao();
        daoLogin.setEntityManager(em);

    }

    @Test
    public void tesUsuarioSenhaInvalido() {

        Vacinador v = new Vacinador();

        v.setNome("InfoSaude");
        v.setCpf("111.233.324-23");
        v.setDataNascimento(new Date());
        v.setMatricula(432432);
        v.setRegistroCoren(423423);
        v.setLogin("InfoSaude");
        v.setSenha("fjosijfew9urj3");
        v.setCodigoEquipeINE("4234");

        Vacinador result = null;
        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();

            result = daoVacinador.buscarPorCampo("cpf", v.getCpf());
        } catch (DaoExcecoes ex) {
            Logger.getLogger(CriaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(432432, result.getMatricula());
    }

}
