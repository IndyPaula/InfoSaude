package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.UnidadeSaudeServiceIF;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 04/05/2015
 */
@Model
public class UnidadeSaudeBean extends GenericoBeans<UnidadeSaude> {

    private boolean operacaoCriar;
    private boolean operacaoAtualizar;

    @Inject
    private UnidadeSaudeServiceIF service;

    @Inject
    private UnidadeSaude unidadeSaude;

    public UnidadeSaudeBean() throws BeanExcecao {
        verificarUnidade();
    }

    public void verificarUnidade() throws BeanExcecao {
        if (buscarTudo().isEmpty()) {
            setOperacaoCriar(true);
            setOperacaoAtualizar(false);
        } else {
            identificavel = (UnidadeSaude) buscarTudo().get(0);
            setOperacaoCriar(false);
            setOperacaoAtualizar(true);
        }
    }

    @Override
    public ServiceIF getService() {
        return service;
    }

    @Override
    public UnidadeSaude getEntidade() {
        if (identificavel == null) {
            identificavel = unidadeSaude;
        }
        return (UnidadeSaude) identificavel;
    }

    @Override
    public void setEntidade(UnidadeSaude identificavel) {
        this.identificavel = identificavel;
    }

    public EnumEstados[] getEstado() {
        return EnumEstados.values();
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
