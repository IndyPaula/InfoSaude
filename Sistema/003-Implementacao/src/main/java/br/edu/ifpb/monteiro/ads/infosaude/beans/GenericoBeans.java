package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.beans.interfaces.BeanIF;
import br.edu.ifpb.monteiro.ads.infosaude.beans.util.FacesMensagens;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 01/05/2015
 */
public abstract class GenericoBeans<T extends Identificavel> implements Serializable, BeanIF<T> {

    private static final long serialVersionUID = 1L;

    public abstract ServiceIF getService();
    public ServiceIF service;
    private List<T> entities;
    private FacesMensagens mensagem;

    protected T identificavel;

    public abstract T getEntidade();

    public abstract void setEntidade(T identificavel);

    public GenericoBeans() {
        entities = new ArrayList<T>();
        mensagem = new FacesMensagens();
    }

    @Override
    public String salvar() throws BeanExcecao {

        try {
            
            getService().salvar(getEntidade());
            entities = getService().buscarTudo();
            T T = null;
            setEntidade(T);
            mensagem.info("Salvo com Sucesso!");
        } catch (ServiceExcecoes ex) {

            Logger.getLogger(GenericoBeans.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";
    }

    @Override
    public String atualizar() throws BeanExcecao {
        try {
            service.atualizar(getEntidade());
            T T = null;
            setEntidade(T);
            service.buscarTudo();
            mensagem.info("Atualizado com Sucesso!");
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(GenericoBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void remover(T identificavel) throws BeanExcecao {
        try {
            service.remover(identificavel);
            service.buscarTudo();
            mensagem.info("Removido com Sucesso!");
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(GenericoBeans.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public T consultarPorId(Long id) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws BeanExcecao {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> buscarTudo() throws BeanExcecao {
        try {
            return service.buscarTudo();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(GenericoBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<T>();
    }

    
    
    
}
