package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.UnidadeSaudeServiceIF;
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
        verificarUnidade();
    }

    private void verificarUnidade() {
        try {
            if (unidadeSaudeService.buscarTudo().isEmpty()) {
                setOperacaoCriar(true);
                setOperacaoAtualizar(false);
            } else {
                setOperacaoCriar(false);
                setOperacaoAtualizar(true);
            }
        } catch (ServiceExcecoes ex) {
            System.out.println("Erro");
        }
    }
    
    public String salvar (){
        
        return null;
    }
    
     public String atualizar (){
        
        return null;
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
