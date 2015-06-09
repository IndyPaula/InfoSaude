package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

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

    private Long idAuxiliar;

    public VacinaBean() {
    }

    @PostConstruct
    public void init() {

        vacinasFilter = new ArrayList<>();

    }

    public Date getDataAtual() {

        return new Date();
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

    public String remover(Vacina vac) {

        if (vac != null) {

            try {
                vacinaService.remover(vac);

                Thread.sleep(1000);

                JsfUtil.redirect("/InfoSaude/resources/paginas/vacina/buscar_vacina.xhtml?faces-redirect=true");
                return "buscar_vacina.xhtml";

            } catch (ServiceExcecoes ex) {
                Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Erro ao tentar remover a vacina");
            } catch (InterruptedException ex) {
                Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JsfUtil.addErrorMessage("Erro ao tentar remover a Vacina");
        }
        return null;
    }

    public String update() throws BeanExcecao {

        try {
            vacina.setId(idAuxiliar);
            vacinaService.atualizar(vacina);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "editar_vacina.xhtml?id=" + vacina.getId();

        } catch (ServiceExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void preparaEdicao() {

        try {
            vacina = vacinaService.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
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
        return null;
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

}
