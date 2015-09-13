package br.edu.ifpb.monteiro.ads.infosaude.relatorios;

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
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

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

    public void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim) {

        try {

            //---------- gera o relatorio ----------  
            String arquivoJASPER = pegarCaminhoRelatorio() + "relatorio_vacina_data_validade.jasper";
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("data_inicio", dataInicio);
            parametros.put("data_fim", dataFim);
            em.getTransaction().begin();
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivoJASPER, parametros, getConexao());

            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            res.setContentType("application/pdf");
            //Código abaixo gerar o relatório e disponibiliza diretamente na página   
            res.setHeader("Content-disposition", "inline;filename=Relatório de vacina por data de validade.pdf");
            //Código abaixo gerar o relatório e disponibiliza para o cliente baixar ou salvar   
            //res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");  
            res.getOutputStream().write(b);
            res.getCharacterEncoding();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
