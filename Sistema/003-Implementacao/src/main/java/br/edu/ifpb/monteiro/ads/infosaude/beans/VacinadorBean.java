package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.CriptografiaUtil;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinadorServiceIF;
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
public class VacinadorBean extends FuncionarioBeanGenerico implements Serializable {

    private transient List<Vacinador> vacinadores;

    @Inject
    private transient Vacinador vacinador;
    private transient Vacinador vacinadorSelected;

    @Inject
    private transient VacinadorServiceIF vacinadorService;

    private transient List<Vacinador> vacinadoresFilter;

    @PostConstruct
    public void init() {

        vacinadoresFilter = new ArrayList<Vacinador>();

    }

    public String salvar() {
        try {
            vacinadorService.verificaCampoUnique("cpf", vacinador.getCpf(), null);
            vacinadorService.verificaCampoUnique("coren", + vacinador.getCoren(), null);
            vacinadorService.verificaCampoUnique("matricula", "" + vacinador.getMatricula(), null);
            vacinadorService.verificaCampoUnique("cartaosus", "" + vacinador.getCartaoSUS(), null);
            vacinadorService.verificaCampoUnique("login", "" + vacinador.getLogin(), null);

            vacinador.setSenha(CriptografiaUtil.convertStringToMd5(vacinador.getSenha()));
            vacinadorService.salvar(vacinador);
            JsfUtil.addSuccessMessage("Vacinador da UBS cadastrado com sucesso");

            return "buscar_vacinador.xhtml";

        } catch (ServiceExcecoes | DaoExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

        }
        return null;
    }

    public Date getDataAtual() {

        return new Date();
    }

    public List<Vacinador> getVacinadores() {

        try {
            vacinadores = vacinadorService.buscarTudo();

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacinadores;
    }

    public void setVacinadores(List<Vacinador> vacinadores) {
        this.vacinadores = vacinadores;
    }

    public String remover() {

        try {
            vacinadorService.remover(vacinadorSelected);

            JsfUtil.addSuccessMessage("Vacinador removido com sucesso");

            return "buscar_vacinador.xhtml";

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public String update() {

        try {
            Long id = vacinadorService.buscarPorCampo("coren", vacinador.getCoren()).getId();

            if (verificaSenhaAtual()) {

                vacinador.setId(id);
                vacinadorService.verificaCampoUnique("cpf", vacinador.getCpf(), id);
                vacinadorService.verificaCampoUnique("coren", "" + vacinador.getCoren(), id);
                vacinadorService.verificaCampoUnique("matricula", "" + vacinador.getMatricula(), id);
                vacinadorService.verificaCampoUnique("cartaosus", "" + vacinador.getCartaoSUS(), id);
                vacinadorService.verificaCampoUnique("login", "" + vacinador.getLogin(), id);

                vacinadorService.atualizar(vacinador);
                JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
                return "buscar_vacinador.xhtml";
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

        vacinador.setSenha(vacinadorService.buscarPorCampo("coren", vacinador.getCoren()).getSenha());

        if(getSenhaTemp().equals("")){
            
            return true;
        }
        if (!CriptografiaUtil.convertStringToMd5(getSenhaAtual()).equals(vacinador.getSenha())) {

            return false;
        }
        if (CriptografiaUtil.convertStringToMd5(getSenhaAtual()).equals(vacinador.getSenha())) {

            vacinador.setSenha(CriptografiaUtil.convertStringToMd5(getSenhaTemp()));
            return true;
        }
        return false;
    }

    public String selecinaExcluir() {

        if (vacinadorSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");

        } else {
            remover();
        }
        return "buscar_vacinador.xhtml";
    }
   public String selecinaEditar() {

        if (vacinadorSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");
            return null;
        } else {
           return "editar_vacinador.xhtml";
        }
        
    }
    public List<Vacinador> getVacinadoresFilter() {
        return vacinadoresFilter;
    }

    public void setVacinadoresFilter(List<Vacinador> vacinadoresFilter) {
        this.vacinadoresFilter = vacinadoresFilter;
    }

    public Vacinador getVacinador() {
        return vacinador;
    }

    public Vacinador getVacinadorSelected() {
        return vacinadorSelected;
    }

    public void setVacinadorSelected(Vacinador vacinadorSelected) {
        this.vacinadorSelected = vacinadorSelected;
    }

    public void setVacinador(Vacinador vacinador) {
        this.vacinador = vacinador;
    }
}
