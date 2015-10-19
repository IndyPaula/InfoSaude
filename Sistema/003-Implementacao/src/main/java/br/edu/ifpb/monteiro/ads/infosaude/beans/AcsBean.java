package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.beans.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ACSServiceIF;
import java.io.Serializable;
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
 * @date 20/05/2015
 */
@Model
public class AcsBean extends FuncionarioBeanGenerico implements Serializable {

    private transient List<ACS> agentes;

    @Inject
    private transient ACS acs;
    private transient ACS acsSelected;

    @Inject
    private transient ACSServiceIF acsService;

    private transient List<ACS> agentesFilter;

    private static final String PAGINA_LISTA_ACS = "buscar_acs.xhtml";

    @PostConstruct
    public void init() {

        agentesFilter = new ArrayList<ACS>();

    }
    public String salvar() {
        try {
            acsService.verificaCampoUnique("cpf", acs.getCpf(), null);
            acsService.verificaCampoUnique("matricula", +acs.getMatricula(), null);
            acsService.verificaCampoUnique("cartaosus", acs.getCartaosus(), null);
            acsService.verificaCampoUnique("login", "" + acs.getLogin(), null);

            acs.setSenha(CriptografiaUtil.convertStringToMd5(acs.getSenha()));
            acsService.salvar(acs);
            JsfUtil.addSuccessMessage("Agente comunitário de Saúde cadastrado com sucesso");

            return PAGINA_LISTA_ACS;

        } catch (ServiceExcecoes | DaoExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

        }
        return null;
    }

    public Date getDataAtual() {

        return new Date();
    }

    public List<ACS> getAgentes() {

        try {
            agentes = acsService.buscarTudo();

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agentes;
    }

    public void setAgentes(List<ACS> acses) {
        this.agentes = acses;
    }

    public String remover() {

        try {
            acsService.remover(acsSelected);

            JsfUtil.addSuccessMessage("Agente comunitário de Saúde removido com sucesso");

            return PAGINA_LISTA_ACS;

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String update() {

        try {

            if (verificaSenhaAtual()) {

                acsService.verificaCampoUnique("cpf", acs.getCpf(), acs.getId());
                acsService.verificaCampoUnique("matricula", +acs.getMatricula(), acs.getId());
                acsService.verificaCampoUnique("cartaosus", acs.getCartaosus(), acs.getId());
                acsService.verificaCampoUnique("login", acs.getLogin(), acs.getId());

                acsService.atualizar(acs);
                JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
                return PAGINA_LISTA_ACS;
            } else {
                JsfUtil.addErrorMessage("A senha informada não corresponde a senha atual");
            }

        } catch (ServiceExcecoes | DaoExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public boolean verificaSenhaAtual() throws ServiceExcecoes {

        acs.setSenha(acsService.consultarPorId(acs.getId()).getSenha());

        if (getSenhaTemp().equals("")) {

            return true;
        }
        if (!CriptografiaUtil.convertStringToMd5(getSenhaAtual()).equals(acs.getSenha())) {

            return false;
        }
        if (CriptografiaUtil.convertStringToMd5(getSenhaAtual()).equals(acs.getSenha())) {

            acs.setSenha(CriptografiaUtil.convertStringToMd5(getSenhaTemp()));
            return true;
        }
        return false;
    }

    public String selecinaExcluir() {

        if (acsSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");

        } else {
            remover();
        }
        return PAGINA_LISTA_ACS;
    }

    public String selecinaEditar() {

        if (acsSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");
            return null;
        } else {
            return "editar_acs.xhtml";
        }

    }

    public List<ACS> getAgentesFilter() {
        return agentesFilter;
    }

    public void setAgentesFilter(List<ACS> acsesFilter) {
        this.agentesFilter = acsesFilter;
    }

    public ACS getACS() {
        return acs;
    }

    public ACS getACSSelected() {
        return acsSelected;
    }

    public void setACSSelected(ACS acsSelected) {
        this.acsSelected = acsSelected;
    }

    public void setACS(ACS acs) {
        this.acs = acs;
    }
}
