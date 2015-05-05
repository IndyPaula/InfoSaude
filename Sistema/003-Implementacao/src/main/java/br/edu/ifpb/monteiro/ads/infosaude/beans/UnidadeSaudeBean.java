package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.service.UnidadeSaudeService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 04/05/2015
 */
@ManagedBean(name = "ubs")
@RequestScoped
public class UnidadeSaudeBean extends GenericoBeans<UnidadeSaude> {

    private boolean operacaoCriar;
    private boolean operacaoAtualizar;

    public UnidadeSaudeBean() throws ServiceExcecoes {
        service = new UnidadeSaudeService();
        verificarUnidade();
    }

    public void verificarUnidade() throws ServiceExcecoes {
        if (service.buscarTudo().isEmpty()) {
            setOperacaoCriar(true);
            setOperacaoAtualizar(false);
        } else {
            identificavel = (UnidadeSaude) service.buscarTudo().get(0);
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
            identificavel = new UnidadeSaude();
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
