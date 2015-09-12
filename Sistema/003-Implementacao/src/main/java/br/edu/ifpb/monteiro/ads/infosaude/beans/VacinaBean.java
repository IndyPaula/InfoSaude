package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.beans.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.relatorios.RelatorioVacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 08/06/2015
 */
@Model
public class VacinaBean {

    @Inject
    private Vacina vacina;

    @Inject
    private VacinaServiceIF vacinaService;

    private String mensangem;

    private List<Vacina> vacinasFilter;

    private Vacina vacinaSelecionada;

    private Date dataInicio;

    private Date dataFim;
    
    private StreamedContent arquivo;

    @Inject
    RelatorioVacina relatorioVacina;

    public VacinaBean() {
    }

    @PostConstruct
    public void init() {

        vacinasFilter = new ArrayList<>();

    }

    public Date getDataAtual() {

        return new Date();
    }

    public String selecinaEditar() {

        if (vacinaSelecionada == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");
            return null;
        } else {
            return "editar_vacina.xhtml";
        }

    }

    public void selecinaExcluir() {

        if (vacinaSelecionada == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");

        } else {
            remover();

        }
    }

    public String remover() {

        try {
            vacinaService.remover(vacinaSelecionada);

            JsfUtil.addSuccessMessage("Vacina removida com sucesso");

            return "buscar_vacina.xhtml";

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String salvar() {
        try {
            vacinaService.salvar(vacina);
            JsfUtil.addSuccessMessage("Vacina cadastrada com sucesso");

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

            return null;

        }
        return "buscar_vacina.xhtml";
    }

    public String update() throws BeanExcecao {

        try {
            vacinaService.atualizar(vacina);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "buscar_vacina.xhtml";

        } catch (ServiceExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void relatorioVacinaDataValidade() {

        relatorioVacina.relatorioVacinaPorDataDeValidade(this.dataInicio, this.dataFim);
        arquivo = relatorioVacina.baixarRelatorio(this.dataInicio, this.dataFim);

    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public List<Vacina> getVacinas() {
        try {
            return vacinaService.buscarTudo();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    public EnumViaAdministracao[] getViaAdministracao() {
        return EnumViaAdministracao.values();
    }

    public String getMensangem() {
        return mensangem;
    }

    public void setMensangem(String mensangem) {
        this.mensangem = mensangem;
    }

    public List<Vacina> getVacinasFilter() {
        return vacinasFilter;
    }

    public void setVacinasFilter(List<Vacina> vacinasFilter) {
        this.vacinasFilter = vacinasFilter;
    }

    public Vacina getVacinaSelecionada() {
        return vacinaSelecionada;
    }

    public void setVacinaSelecionada(Vacina vacinaSelecionada) {
        this.vacinaSelecionada = vacinaSelecionada;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public StreamedContent getArquivo() {
        return arquivo;
    }
    
}
