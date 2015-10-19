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

    private Vacina vacinaDaUbs;

    @Mock
    private VacinaDaoIF dao;

    public VacinaServiceTest() {
        servie = new VacinaServie();
    }

    @Before
    public void setUpClass() {

        MockitoAnnotations.initMocks(this);

        vacinaDaUbs = new Vacina();
        vacinaDaUbs.setContraIndicacoes("123");
        vacinaDaUbs.setDataFabricacao(new Date());
        vacinaDaUbs.setDataVencimento(new Date());
        vacinaDaUbs.setId(1235L);
        vacinaDaUbs.setInstrucaoAdministracao("123");
        vacinaDaUbs.setInstrucaoArmazenamento("123");
        vacinaDaUbs.setLaboratorio("123");
        vacinaDaUbs.setLote("123");
        vacinaDaUbs.setNome("123");
        vacinaDaUbs.setQuantidadeDosesRecebidas(3);
        vacinaDaUbs.setReacoesAdversas("123");
        vacinaDaUbs.setViaAdministracao(EnumViaAdministracao.ORAL);

        try {
            when(dao.salvar(vacinaDaUbs)).thenReturn(vacinaDaUbs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testSalvar() {

        Vacina result = null;
        try {
            result = dao.salvar(vacinaDaUbs);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(VacinaServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(result.getNome(), vacinaDaUbs.getNome());

    }

}
