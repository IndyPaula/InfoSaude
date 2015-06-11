package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.PacienteDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Vanderlan Gomes
 * @date 22/05/2015
 */
public class PacienteServiceTest {
    
    private static PacienteService service;

    private Paciente paciente;

    @Mock
    private PacienteDaoIF dao;

    public PacienteServiceTest() {

        service = new PacienteService();
    }

    @Before
    public void setUpClass() {

        MockitoAnnotations.initMocks(this);

        paciente = new Paciente();
        paciente.setNome("Vanderlan Gomes");
        paciente.setCpf("10145473422");
        paciente.setDataNascimento(new Date());
        paciente.setDataCadastro(new Date());
        paciente.setBairro("Centro");
        paciente.setCep("5487598");
        paciente.setCidade("Monteiro");
        paciente.setEstado(EnumEstados.PB);
        paciente.setLogradouro("Av. Principal");

        try {
            when(dao.salvar(paciente)).thenReturn(paciente);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSalvar() {

        Paciente result = null;
        try {
            result = dao.salvar(paciente);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(PacienteServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(result.getNome(), paciente.getNome());

    }
    
}
