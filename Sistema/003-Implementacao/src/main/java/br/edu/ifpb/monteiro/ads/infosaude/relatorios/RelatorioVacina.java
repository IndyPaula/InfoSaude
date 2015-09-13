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

    /*
     Injeta o EntityManager 
     */
    @Inject
    private EntityManager em;

    /*
     Construtor padrão
     */
    public RelatorioVacina() {
    }

    /*
     Pegar a conexão com o banco
     */
    private Connection getConexao() {
        // EntityManager.unwrap - retorna a conexão ativa com as devidas 
        // permissões
        return em.unwrap(Connection.class);
    }

    /*
     Método para fechar a conexão      
     */
    private void fecharConexao() {
        // se a conexão for diferente de nulo
        if (getConexao() != null) {
            try {
                // fecha conexão
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

    /*
     Método para pegar o caminho completo do local onde está os relatórios
     */
    private String pegarCaminhoRelatorio() {

        return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/relatorios/");

    }

    /*
     Método para gerar o relatório e disponibilizar para visualização do usuário
     parametros utilizados dataInicio e dataFim são os solicitados no arquivo jasper.
     */
    public void relatorioVacinaPorDataDeValidade(Date dataInicio, Date dataFim) {

        try {

            // caminho completo do arquivo jasper
            String arquivoJASPER = pegarCaminhoRelatorio() + "relatorio_vacina_data_validade.jasper";

            // Map com os parametros utilizados como parametros no arquivo jasper
            Map<String, Object> parametros = new HashMap<String, Object>();

            // data de inicio para vencimento das vacinas. O 'data_inicio' passado como parametro no arquivo jasper
            parametros.put("data_inicio", dataInicio);

            // data de limite para vencimento das vacinas. O 'data_fim' passado como parametro no arquivo jasper
            parametros.put("data_fim", dataFim);

            // abre a conexão com o banco de dados
            em.getTransaction().begin();

            /* Resultado do relatório o jasperprint representa o documento gerado. Ao preencher relatório com os dados, 
             os resultados podem ser enviados pela rede, armazenados em um formulário serializado em disco ou 
             exportados para vários outros formatos, como PDF, HTML, XLS, CSV ou XML. 
            
             O JasperFillManager é uma fachada para a classe que será utilizada para buscar os dados na base de dados
             este porde ser obtido de varias formas. Aqui passamos como parametro do fillReport o 'local do arquivo',
             os parametros que seram passados na consulta para o relatório e a conexao com o banco
             */
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivoJASPER, parametros, getConexao());

            // Array de byte do relatório no formato pdf. o JasperExportManager é uma fachada para os tipos de modelos que 
            // podem ser gerados a partir do resultado do jasperPrint
            // Aqui foi utilizado o exportReportToPdf para exportar o relatorio passado como parametro para o formato pdf 
            byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

            // Permite passar informações no cabeçalho da página: o nome do arquivo de download, o contentType que é uma
            // arquivo aplication/pdf por ser um pdf, por exemplo
            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            // passando o tipo do arquivo de saida
            res.setContentType("application/pdf");
            
            //Gerar o relatório e disponibiliza diretamente na página. passando como parametro no cabeçario
            // o o Content-disposition acho 'que indica que os parametros devem está disponivel no inicio do cabeçario,
            // o inline para ser mostrado altomaticamente e o filename com o nome do arquivo para download.
            res.setHeader("Content-disposition", "inline;filename=Relatório de vacina por data de validade.pdf");
            
            //Código abaixo gerar o relatório e disponibiliza para o cliente baixar ou salvar   
            // ---> res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");  
            
            // response, criar o arquipo contido em b 'array de byte do relatório'
            res.getOutputStream().write(b);
            
            // retorna a codificação de caractere utilizada
            res.getCharacterEncoding();
            
            // Confirma o termino da execução para pagina jsf. Não permitindo alteração após  
            // a execução do relatório
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
