package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.UnidadeSaudeDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Vanderlan Gomes
 * @date 22/05/2015
 */
public class UnidadeSaudeServiceTest {

    private static UnidadeSaudeService service;

    private UnidadeSaude ubs;

    @Mock
    private UnidadeSaudeDaoIF dao;

    public UnidadeSaudeServiceTest() {

        service = new UnidadeSaudeService();
    }

    @Before
    public void setUpClass() {

        MockitoAnnotations.initMocks(this);

        ubs = new UnidadeSaude();
        ubs.setBairro("Centro");
        ubs.setCep("5487598");
        ubs.setCidade("Monteiro");
        ubs.setCnes(392);
        ubs.setEnderecoNumero(200);
        ubs.setEstado(EnumEstados.PB);
        ubs.setLogradouro("Av. Principal");
        ubs.setNome("UBS 09");
        ubs.setNumero(1276);

        try {
            when(dao.salvar(ubs)).thenReturn(ubs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSalvar() {

        UnidadeSaude result = null;
        try {
            result = dao.salvar(ubs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(UnidadeSaudeServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(result.getCnes(), ubs.getCnes());

    }

}
