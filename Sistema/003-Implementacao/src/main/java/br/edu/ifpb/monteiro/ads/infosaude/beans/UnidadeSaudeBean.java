package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.UnidadeSaudeServiceIF;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 21/05/2015
 */
@Model
public class UnidadeSaudeBean {

    @Inject
    private UnidadeSaudeServiceIF unidadeSaudeService;

    @Inject
    private UnidadeSaude unidadeSaude;

    private boolean operacaoCriar;
    private boolean operacaoAtualizar;

    public UnidadeSaudeBean() {

    }

    @PostConstruct
    public void init(){
        verificarUnidade();
    }
    
    public void verificarUnidade() {
        try {
            if (unidadeSaudeService.buscarTudo().isEmpty()) {
                setOperacaoCriar(true);
                setOperacaoAtualizar(false);
            } else {
                unidadeSaude = unidadeSaudeService.buscarTudo().get(0);
                setOperacaoCriar(false);
                setOperacaoAtualizar(true);
            }
        } catch (ServiceExcecoes ex) {
            System.out.println("Erro");
        }
    }
    
    public String salvar (){
        try {
            unidadeSaudeService.salvar(unidadeSaude);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(UnidadeSaudeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public String atualizar (){
        try {
            unidadeSaudeService.atualizar(unidadeSaude);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(UnidadeSaudeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     

     public EnumEstados[] getEstado() {
        return EnumEstados.values();
    }
    public UnidadeSaudeServiceIF getUnidadeSaudeService() {
        return unidadeSaudeService;
    }

    public void setUnidadeSaudeService(UnidadeSaudeServiceIF unidadeSaudeService) {
        this.unidadeSaudeService = unidadeSaudeService;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public boolean isOperacaoCriar() {
        return operacaoCriar;
    }

    public void setOperacaoCriar(boolean operacaoCriar) {
        this.operacaoCriar = operacaoCriar;
    }

    public boolean isOperacaoAtualizar() {
        return operacaoAtualizar;
    }

    public void setOperacaoAtualizar(boolean operacaoAtualizar) {
        this.operacaoAtualizar = operacaoAtualizar;
    }

}
