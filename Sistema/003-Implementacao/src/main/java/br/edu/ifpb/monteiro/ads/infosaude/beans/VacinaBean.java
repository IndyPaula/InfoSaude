package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.beans.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.MotivoRetirada;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ControleEstoqueVacinaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

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
    private ControleEstoqueVacina controleEstoqueVacina;

    @Inject
    private VacinaServiceIF vacinaService;

    @Inject
    private ControleEstoqueVacinaServiceIF controleEstoqueVacinaServiceIF;

    private String mensangem;

    private List<Vacina> vacinasFilter;

    private Vacina vacinaSelecionada;

    private Date dataInicio;

    private Date dataFim;

    private Vacina v;

    private FacesContext context = FacesContext.getCurrentInstance();

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
            vacina.setDataCadastro(getDataAtual());
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

    public void relatorioVacinaPorDataDeValidade() throws ServiceExcecoes {

        if (this.dataInicio.before(this.dataFim)) {
            vacinaService.relatorioVacinaPorDataDeValidade(this.dataInicio, this.dataFim);
        } else {
            JsfUtil.addErrorMessage("Data inicial deve ser anterior a data final");
        }
    }

    public void relatorioVacinaImunobiologico() throws ServiceExcecoes {
        if (this.dataInicio.before(this.dataFim)) {
            vacinaService.relatorioVacinaImunobiologico(this.dataInicio, this.dataFim);
        } else {
            JsfUtil.addErrorMessage("Data inicial deve ser anterior a data final");
        }
    }

    public String editarQuantidadeDose() {

        try {
            int valor = controleEstoqueVacinaServiceIF.quantidadeDeVacina(vacinaSelecionada);
            if ((valor <= controleEstoqueVacina.getQuantidadeDoses())
                    && (valor > 0)) {

                v = (Vacina) context.getExternalContext().getSessionMap().put("vacina", vacinaSelecionada);
                controleEstoqueVacina.setDataRetirada(new Date());
                controleEstoqueVacina.setVacina(v);
                controleEstoqueVacinaServiceIF.salvar(controleEstoqueVacina);
            } else {
                JsfUtil.addErrorMessage("Sistema indica que a vacina " + vacinaSelecionada.getNome() + " do lote " + vacinaSelecionada.getLote() + " já foi completamente utilizada!");
            }
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "buscar_vacina.xhtml";
    }

    public void selecionarVacina() {
        if (getQuantidadeVacina() > 0) {
            RequestContext.getCurrentInstance().execute("PF('editarQuantidadeDose').show();");
            context.getExternalContext().getSessionMap().put("vacina", vacinaSelecionada);
        } else {
            JsfUtil.addErrorMessage("Sistema indica que a vacina " + vacinaSelecionada.getNome() + " do lote " + vacinaSelecionada.getLote() + " já foi completamente utilizada!");
        }
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
            Logger.getLogger(VacinaBean.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    public EnumViaAdministracao[] getViaAdministracao() {
        return EnumViaAdministracao.values();
    }

    public MotivoRetirada[] getMotivoRetirada() {
        return MotivoRetirada.values();
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

    public ControleEstoqueVacina getControleEstoqueVacina() {
        return controleEstoqueVacina;
    }

    public void setControleEstoqueVacina(ControleEstoqueVacina controleEstoqueVacina) {
        this.controleEstoqueVacina = controleEstoqueVacina;
    }

    public int getQuantidadeVacina() {
        int quantidadeVacina = 0;
        try {
            v = (Vacina) context.getExternalContext().getSessionMap().put("vacina", vacinaSelecionada);
            quantidadeVacina = controleEstoqueVacinaServiceIF.quantidadeDeVacina(v);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (quantidadeVacina > 0) {
            return quantidadeVacina;
        } else {
            return quantidadeVacina;
        }
    }

}
