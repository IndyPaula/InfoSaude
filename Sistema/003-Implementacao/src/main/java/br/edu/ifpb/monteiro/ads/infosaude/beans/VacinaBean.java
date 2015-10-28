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

    Vacina vacinaEstoque;

    private FacesContext context = FacesContext.getCurrentInstance();

    private int quantidadeVacina = 0;

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
        context.getExternalContext().getSessionMap().put("vacina", vacinaSelecionada);
        if (vacinaSelecionada == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");
            return null;
        } else {
            return "editar_vacina.xhtml";
        }

    }

    public void selecinaExcluir() throws ServiceExcecoes {

        if (vacinaSelecionada == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");

        } else if (controleEstoqueVacinaServiceIF.verificarVacinaRemover(vacinaSelecionada) >0 ){
            
            
        }else {
            remover();

        }
    }

    public String remover() {

        try {
            int testeIF = controleEstoqueVacinaServiceIF.verificarVacinaRemover(vacinaSelecionada);
            if (testeIF == 0) {
                vacinaService.remover(vacinaSelecionada);
                JsfUtil.addSuccessMessage("Vacina removida com sucesso");

                return "buscar_vacina.xhtml";
            } else {
                JsfUtil.addErrorMessage("Vacina não pode ser removida pois consta nos registros com doses ja utilizadas");
            }

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
            Vacina pegarData = vacinaService.consultarPorId(vacina.getId());
            Date dataDeCadastro = pegarData.getDataCadastro();
            vacina.setDataCadastro(dataDeCadastro);
            vacinaService.atualizar(vacina);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "buscar_vacina.xhtml";

        } catch (ServiceExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

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
            vacinaEstoque = (Vacina) context.getExternalContext().getSessionMap().get("vacina");
            quantidadeVacina = controleEstoqueVacinaServiceIF.quantidadeDeVacina(vacinaEstoque);

            if ((quantidadeVacina >= controleEstoqueVacina.getQuantidadeDoses())
                    && (quantidadeVacina > 0)) {
                controleEstoqueVacina.setDataRetirada(new Date());
                controleEstoqueVacina.setVacina(vacinaEstoque);
                controleEstoqueVacinaServiceIF.salvar(controleEstoqueVacina);
                JsfUtil.addSuccessMessage("Foram removidas " + controleEstoqueVacina.getQuantidadeDoses() + " doses");
                return "buscar_vacina.xhtml";
            } else {
                JsfUtil.addErrorMessage("Só existem " + quantidadeVacina + " doses da vacina "
                        + vacinaEstoque.getNome() + " do lote " + vacinaEstoque.getLote());
                return "buscar_vacina.xhtml";
            }
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
            return "buscar_vacina.xhtml";
        }

    }

    public void selecionarVacina() {

        try {
            vacinaEstoque = (Vacina) context.getExternalContext().getSessionMap().get("vacina");
            quantidadeVacina = controleEstoqueVacinaServiceIF.quantidadeDeVacina(vacinaEstoque);

            if (quantidadeVacina > 0) {
                RequestContext.getCurrentInstance().execute("PF('editarQuantidadeDose').show();");
            } else {
                JsfUtil.addErrorMessage("A vacina " + vacinaEstoque.getNome() + " do lote " + vacinaEstoque.getLote() + ""
                        + " não tem doses armazenadas");
            }

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
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

}
