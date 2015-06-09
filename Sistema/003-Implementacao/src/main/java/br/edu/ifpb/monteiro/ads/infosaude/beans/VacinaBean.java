package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinaServiceIF;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public VacinaBean() {
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

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public EnumViaAdministracao[] getViaAdministracao() {
        return EnumViaAdministracao.values();
    }

}
