package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
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
public class AcsBean implements Serializable {

    private String confirmarSenha;

    private transient List<ACS> agentes;

    @Inject
    private transient ACS acs;
    private transient ACS acsSelected;

    private Long idAuxiliar;

    @Inject
    private transient ACSServiceIF acsService;

    private String senhaAtual;
    private String senhaTemp;

    private transient List<ACS> agentesFilter;

    @PostConstruct
    public void init() {

        agentesFilter = new ArrayList<ACS>();

    }

    public String salvar() {
        try {
            acsService.verificaCampoUnique("cpf", acs.getCpf(), null);
            acsService.verificaCampoUnique("cbo", "" + acs.getCbo(), null);
            acsService.verificaCampoUnique("matricula", "" + acs.getMatricula(), null);
            acsService.verificaCampoUnique("login", "" + acs.getLogin(), null);

            acs.setSenha(CriptografiaUtil.convertStringToMd5(acs.getSenha()));
            acsService.salvar(acs);
            JsfUtil.addSuccessMessage("Agente comunitário de Saúde cadastrado com sucesso");
            
            return "buscar_acs.xhtml";

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

    public void preparaEdicao() {

        try {
            this.acs = acsService.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String remover() {

        try {
            acsService.remover(acsSelected);
            
            JsfUtil.addSuccessMessage("Agente comunitário de Saúde removido com sucesso");
            
            return "buscar_acs.xhtml";

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String update() {

        if (verificaSenhaAtual()) {
            try {

                acsService.verificaCampoUnique("cpf", acs.getCpf(), idAuxiliar);
                acsService.verificaCampoUnique("cbo", "" + acs.getCbo(), idAuxiliar);
                acsService.verificaCampoUnique("matricula", "" + acs.getMatricula(), idAuxiliar);
                acsService.verificaCampoUnique("login", "" + acs.getLogin(), idAuxiliar);

                acs.setId(idAuxiliar);
                acsService.atualizar(acs);
                JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
                return "buscar_acs.xhtml";

            } catch (ServiceExcecoes | DaoExcecoes ex) {

                Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
                return "editar_acs.xhtml?id=" + idAuxiliar + "&faces-redirect=true";

            }
        }
        return "editar_acs.xhtml?id=" + idAuxiliar;
    }

    public boolean verificaSenhaAtual() {

        try {
            if (CriptografiaUtil.convertStringToMd5(senhaAtual).
                    equals(acsService.buscarPorCampo("id", idAuxiliar).getSenha())) {
              
                return true;

            } else {
                if (senhaAtual.trim() == "") {
                     acs.setSenha(acsService.buscarPorCampo("id", idAuxiliar).getSenha());
                    return true;
                } else {
                    JsfUtil.addErrorMessage("A senha digitada não corresponde a senha atual");
                }
            }
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AcsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

     public String selecinaExcluir() {

         if(acsSelected == null){
             JsfUtil.addErrorMessage("Selecione um item da tabela");
                          
         }
         else{
             remover();
         }
        return "buscar_acs.xhtml";
    }
     public void selecinaEditar() {

         if(acsSelected == null){
             JsfUtil.addErrorMessage("Selecione um item da tabela");
         }
         else{
             JsfUtil.redirect("editar_acs.xhtml?id="+acsSelected.getId()+"&faces-redirect=true");
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

    public String getSenhaTemp() {
        return senhaTemp;
    }

    public void setSenhaTemp(String senhaTemp) {
        this.senhaTemp = senhaTemp;
    }

    public EnumEstados[] getEstado() {
        return EnumEstados.values();
    }

    public EnumGeneros[] getSexo() {
        return EnumGeneros.values();
    }

    public EnumEtnias[] getEtnias() {
        return EnumEtnias.values();
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    public Long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

}
