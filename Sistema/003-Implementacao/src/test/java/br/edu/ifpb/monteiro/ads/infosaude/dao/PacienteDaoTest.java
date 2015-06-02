package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
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

    @Before
    public void preparaDao() {
        daoPaciente = new PacienteDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer("InfoSaudePUTest");
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoPaciente.setEntityManager(em);

    }

    @After
    public void limpaEntityManager() {

        daoPaciente.getEntityManager().clear();
    }

    @Test
    public void testPacienteValido() {

        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("534534534");
        paciente.setNome("Vanderlan Gomes da Silva");
        paciente.setCpf("10145473422");
        paciente.setDataNascimento(new Date());
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

    @Test(expected = ConstraintViolationException.class)
    public void testCpfNull() {
        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("534534534");
        paciente.setNome("Fulano Alves");
        paciente.setDataNascimento(new Date());
        paciente.setNumeroProntuario(4234);
        paciente.setDataCadastro(new Date());
        paciente.setSexo(EnumGeneros.MASCULINO);

        boolean validadation = true;

        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente);
            daoPaciente.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {

            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(false, validadation);
    }

    @Test
    public void testEdicao() {

        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("99994325252");
        paciente.setNome("Vanderlan Gomes");
        paciente.setCpf("432.543.576-31");
        paciente.setDataNascimento(new Date());
        paciente.setNumeroProntuario(55655555);
        paciente.setDataCadastro(new Date());
        paciente.setSexo(EnumGeneros.MASCULINO);
        paciente.setEstado(EnumEstados.PE);

        Paciente result = null;
        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paciente);

            Paciente paciente2 = daoPaciente.buscarPorCampo("cpf", "432.543.576-31");
            paciente2.setNome("Vanderlan Gomes da Silva");

            daoPaciente.atualizar(paciente2);
            daoPaciente.getEntityManager().getTransaction().commit();

            result = daoPaciente.buscarPorCampo("cpf", "432.543.576-31");

        } catch (DaoExcecoes ex) {
            daoPaciente.getEntityManager().clear();
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(result.getNome(), "Vanderlan Gomes da Silva");
    }

}
