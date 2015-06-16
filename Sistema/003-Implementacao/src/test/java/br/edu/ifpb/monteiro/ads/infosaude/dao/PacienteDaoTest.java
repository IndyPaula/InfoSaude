package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import org.junit.After;
import org.junit.Assert;
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

        Paciente pac2 = new Paciente();
        pac2.setCartaoSUS("534534534");
        pac2.setNome("Vanderlan Gomes da Silva");
        pac2.setCpf("10145473422");
        pac2.setDataNascimento(new Date());
        pac2.setNumeroProntuario(4234);
        pac2.setDataCadastro(new Date());
        pac2.setSexo(EnumGeneros.MASCULINO);

        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(pac2);
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
        assertEquals(pac2.getId(), result.getId());
    }

    @Test(expected = RollbackException.class)
    public void testCpfNull() {
        Paciente pacienteUbs = new Paciente();
        pacienteUbs.setCartaoSUS("534534534");
        pacienteUbs.setNome("Fulano Alves");
        pacienteUbs.setDataNascimento(new Date());
        pacienteUbs.setNumeroProntuario(4234);
        pacienteUbs.setDataCadastro(new Date());
        pacienteUbs.setSexo(EnumGeneros.MASCULINO);

        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(pacienteUbs);
            daoPaciente.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {

            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Test
    public void testEdicao() {

        Paciente pac = new Paciente();
        pac.setCartaoSUS("99994325252");
        pac.setNome("Vanderlan Gomes");
        pac.setCpf("432.543.576-31");
        pac.setDataNascimento(new Date());
        pac.setNumeroProntuario(55655555);
        pac.setDataCadastro(new Date());
        pac.setSexo(EnumGeneros.MASCULINO);
        pac.setEstado(EnumEstados.PE);

        Paciente result = null;
        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(pac);

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

    @Test
    public void testBuscarTodosPorCampo() {

        Paciente paci = new Paciente();
        paci.setCartaoSUS("77753453490");
        paci.setNome("Paciente");
        paci.setCpf("90145473422");
        paci.setDataNascimento(new Date());
        paci.setNumeroProntuario(42314);
        paci.setDataCadastro(new Date());
        paci.setSexo(EnumGeneros.MASCULINO);

        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(paci);
            daoPaciente.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        int quantidade = 0;
        List<Paciente> pacientes;

        try {
            pacientes = daoPaciente.buscarTodosPorCampo("nome", "Paciendew");
        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            pacientes = daoPaciente.buscarTodosPorCampo("nome", "Paciente");

            quantidade = pacientes.size();

        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(quantidade, 1);
    }

    @Test
    public void testBuscarTodos() {

        boolean validation = false;
        try {

            List<Paciente> pacientes = daoPaciente.buscarTudo();

            if (!pacientes.isEmpty()) {
                validation = true;
            }

        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(validation, true);
    }

    @Test
    public void testRemocao() {

        Paciente pacienteTestRemocao = new Paciente();
        pacienteTestRemocao.setCartaoSUS("77743383490");
        pacienteTestRemocao.setNome("Paciente");
        pacienteTestRemocao.setCpf("87745473422");
        pacienteTestRemocao.setDataNascimento(new Date());
        pacienteTestRemocao.setNumeroProntuario(4999994);
        pacienteTestRemocao.setDataCadastro(new Date());
        pacienteTestRemocao.setSexo(EnumGeneros.MASCULINO);

        try {

            daoPaciente.getEntityManager().getTransaction().begin();
            daoPaciente.salvar(pacienteTestRemocao);
            daoPaciente.getEntityManager().getTransaction().commit();

        } catch (DaoExcecoes ex) {

            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }

        Paciente pac = null;
        Paciente result = null;
        try {

            pac = daoPaciente.buscarPorCampo("cpf", "87745473422");

            daoPaciente.remover(pac);

            result = daoPaciente.buscarPorCampo("cpf", "87745473422");

        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        assertEquals(result, null);
    }

    @Test
    public void testAtributos() {

        Paciente p = new Paciente();
        p.setCartaoSUS("534534534");
        p.setNome("Vanderlan Gomes da Silva");
        p.setCpf("10145473422");
        p.setDataNascimento(new Date());
        p.setNumeroProntuario(4234);
        p.setDataCadastro(new Date());
        p.setSexo(EnumGeneros.MASCULINO);
        p.setRg("882134");
        p.setId(Long.MAX_VALUE);
        p.setNomeMae("Maria");
        p.setNomePai("Jose");
        p.setAltura(1.8);
        p.setPesoNascer(3.4);
        p.setNumero(23);
        p.setCep("2134");
        p.setCidade("Monteiro");
        p.setBairro("Centro");
        p.setEstado(EnumEstados.PB);
        p.setOrgaoEmissor("SDS");
        p.setUfOrgaoEmissor(EnumEstados.PB);
        p.setEtnia(EnumEtnias.PARDO);
        p.setLogradouro("Av. Principal");

        Paciente p2 = new Paciente();
        p2.setCartaoSUS("534534534");
        p2.setNome("Vanderlan Gomes da Silva");
        p2.setCpf("10145473422");
        p2.setDataNascimento(new Date());
        p2.setNumeroProntuario(4234);
        p2.setDataCadastro(new Date());
        p2.setSexo(EnumGeneros.MASCULINO);
        p2.setRg("882134");
        p2.setId(Long.MAX_VALUE);
        p2.setNomeMae("Maria");
        p2.setNomePai("Jose");
        p2.setAltura(1.8);
        p2.setPesoNascer(3.4);
        p2.setNumero(23);
        p2.setCep("2134");
        p2.setCidade("Monteiro");
        p2.setBairro("Centro");
        p2.setEstado(EnumEstados.PB);
        p2.setOrgaoEmissor("SDS");
        p2.setUfOrgaoEmissor(EnumEstados.PB);
        p2.setEtnia(EnumEtnias.PARDO);
        p2.setLogradouro("Av. Principal");

        Assert.assertTrue(!p.equals(new Paciente()));

        assertEquals(p2.getCartaoSUS(), "534534534");
        assertEquals(p2.getSexo(), EnumGeneros.MASCULINO);
        assertEquals(p2.getCartaoSUS(), "534534534");
        assertEquals(p2.getNomeMae(), "Maria");
        assertEquals(p2.getNomePai(), "Jose");
        assertEquals(p2.getNumero(), p2.getNumero());
        assertEquals(p2.getCep(), "2134");
        assertEquals(p2.getCidade(), "Monteiro");
        assertEquals(p2.getBairro(), "Centro");
        assertEquals(p2.getLogradouro(), p.getLogradouro());
        assertEquals(p2.getRg(), p.getRg());
        assertEquals(p2.getEstado(), EnumEstados.PB);
        assertEquals(p2.getOrgaoEmissor(), "SDS");
        assertEquals(p2.getUfOrgaoEmissor(), EnumEstados.PB);
        assertEquals(p2.getEtnia(), EnumEtnias.PARDO);

        assertEquals(p, p2);
    }
}
