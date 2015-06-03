package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinadorServiceIF;
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
public class VacinadorBean {

    private String confirmarSenha;

    private List<Vacinador> vacinadores;

    @Inject
    private Vacinador vacinador;

    private Long idAuxiliar;

    @Inject
    private VacinadorServiceIF vacinadorService;

    private String mensangem;

    private List<Vacinador> vacinadoresFilter;

    @PostConstruct
    public void init() {

        vacinadoresFilter = new ArrayList<Vacinador>();

    }

    public String salvar() {
        try {
            vacinadorService.verificaCampoUnique("cpf", vacinador.getCpf(), null);
            vacinadorService.verificaCampoUnique("coren", "" + vacinador.getCoren(), null);
            vacinadorService.verificaCampoUnique("matricula", "" + vacinador.getMatricula(), null);
            vacinadorService.verificaCampoUnique("login", "" + vacinador.getLogin(), null);

            vacinadorService.salvar(vacinador);
            JsfUtil.addSuccessMessage("Vacinador da UBS cadastrado com sucesso");

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

            return null;

        } catch (DaoExcecoes ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
            return null;
        }
        return "buscar_vacinador.xhtml";
    }

    public Date getDataAtual() {

        return new Date();
    }

    public List<Vacinador> getVacinadores() {

        try {
            this.vacinadores = vacinadorService.buscarTudo();
            return vacinadores;
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setVacinadores(List<Vacinador> vacinadores) {
        this.vacinadores = vacinadores;
    }

    public void preparaEdicao() {

        try {
            this.vacinador = vacinadorService.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mensagem() {
        if ("true".equals(mensangem)) {
            JsfUtil.addSuccessMessage("Vacinador da UBS removido com sucesso");

        }
    }

    public String remover(Vacinador vacinadorLocal) {

        if (vacinadorLocal != null) {

            try {
                vacinadorService.remover(vacinadorLocal);

                Thread.sleep(1000);

                JsfUtil.redirect("/InfoSaude/resources/paginas/imunizacao/buscar_vacinador.xhtml?faces-redirect=true");
                return "buscar_vacinador.xhtml";

            } catch (ServiceExcecoes ex) {
                Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Erro ao tentar remover vacinador");
            } catch (InterruptedException ex) {
                Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JsfUtil.addErrorMessage("Erro ao tentar remover Vacinador da UBS");
        }
        return null;
    }

    public String update() throws BeanExcecao {

        try {

            vacinadorService.verificaCampoUnique("cpf", vacinador.getCpf(), idAuxiliar);
            vacinadorService.verificaCampoUnique("coren", "" + vacinador.getCoren(), idAuxiliar);
            vacinadorService.verificaCampoUnique("matricula", "" + vacinador.getMatricula(), idAuxiliar);
            vacinadorService.verificaCampoUnique("login", "" + vacinador.getLogin(), idAuxiliar);

            vacinador.setId(idAuxiliar);
            vacinadorService.atualizar(vacinador);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "buscar_vacinador.xhtml";

        } catch (ServiceExcecoes | DaoExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            return "editar_vacinador.xhtml?id=" + vacinador.getId();

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

    public void setVacinador(Vacinador vacinador) {
        this.vacinador = vacinador;
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

    public void setMensangem(String mensangem) {
        this.mensangem = mensangem;
    }

    public String getMensangem() {
        return mensangem;
    }

    public Long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

}
