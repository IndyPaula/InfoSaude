package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.VacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
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
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 09/06/2015
 */
public class VacinaServiceTest {

    private static VacinaServie servie;

    private Vacina vacina;

    @Mock
    private VacinaDaoIF dao;

    public VacinaServiceTest() {
        servie = new VacinaServie();
    }

    @Before
    public void setUpClass() {

        MockitoAnnotations.initMocks(this);

        vacina = new Vacina();
        vacina.setContraIndicacoes("123");
        vacina.setDataFabricacao(new Date());
        vacina.setDataVencimento(new Date());
        vacina.setId(1235L);
        vacina.setInstrucaoAdministracao("123");
        vacina.setInstrucaoArmazenamento("123");
        vacina.setLaboratorio("123");
        vacina.setLote("123");
        vacina.setNome("123");
        vacina.setQuantidadeDoses(3);
        vacina.setReacoesAdversas("123");
        vacina.setViaAdministracao(EnumViaAdministracao.ORAL);

        try {
            when(dao.salvar(vacina)).thenReturn(vacina);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testSalvar() {

        Vacina result = null;
        try {
            result = dao.salvar(vacina);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(result.getNome(), vacina.getNome());

    }

}
