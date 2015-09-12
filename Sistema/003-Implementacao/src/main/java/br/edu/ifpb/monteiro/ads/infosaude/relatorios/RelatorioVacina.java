package br.edu.ifpb.monteiro.ads.infosaude.relatorios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 09/09/2015
 */
public class RelatorioVacina {

    @Inject
    private EntityManager em;

    public RelatorioVacina() {
    }

    private Connection getConexao() {
        
        return em.unwrap(Connection.class);
    }

    private void fecharConexao() {
        if (getConexao() != null) {
            try {
                getConexao().close();
            } catch (SQLException e) {
                try {
                    throw new SQLException("Erro ao fechara conexão", e);
                } catch (SQLException ex) {
                    Logger.getLogger(RelatorioVacina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private String pegarCaminhoRelatorio() {
        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/relatorios/");
        
    }

    public StreamedContent baixarRelatorio(Date dataInicio, Date dataFim) {

        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(pegarCaminhoRelatorio()
                + "vacinas com data de vencimento entre: " + dataInicio + " e " + dataFim + ".pdf");
        return new DefaultStreamedContent(stream, "application/pdf", "vacinas com data de vencimento entre: "
                + dataInicio + " e " + dataFim + ".pdf");
    }

    public void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim) {

        try {
            String arquivoJASPER = pegarCaminhoRelatorio() + "relatorio_vacina_data_validade.jasper";
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("data_inicio", dataInicio);
            parametros.put("data_fim", dataFim);
            em.getTransaction().begin();
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivoJASPER, parametros, getConexao());
            JRExporter jRExport = new JRPdfExporter();
            jRExport.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jRExport.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(pegarCaminhoRelatorio() + "vacinas com data de vencimento entre: "
                    + dataInicio + " e " + dataFim + ".pdf"));
            jRExport.exportReport();

        } catch (JRException | FileNotFoundException e) {
            throw new RuntimeException("Não foi possivel gerar o relatório", e);
        } finally {
            fecharConexao();
        }
    }

}
