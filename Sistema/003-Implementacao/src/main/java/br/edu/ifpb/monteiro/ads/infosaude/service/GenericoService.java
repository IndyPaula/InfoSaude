package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.GenericoDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public abstract class GenericoService<T extends Identificavel> implements Serializable, ServiceIF<T> {
    
    public DaoIF dao;

    public GenericoService() {
    
        dao = new GenericoDao();
    }

    
    @Override
    public T salvar(T identificadorGenerico) throws ServiceExcecoes {
        try {
             dao.salvar(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identificadorGenerico;
    }

    @Override
    public T atualizar(T identificadorGenerico) throws ServiceExcecoes {
        try {
            dao.atualizar(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identificadorGenerico;
    }

    @Override
    public void remover(T identificadorGenerico) throws ServiceExcecoes {
        try {
            dao.remover(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public T consultarPorId(Long id) throws ServiceExcecoes {
        try {
            return (T) dao.consultarPorId(id);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Consultar por ID", ex);
        }
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return (T) dao.buscarPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            
            throw new ServiceExcecoes("Erro no Service ao Buscar por Campo", ex);
                        
        }
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return dao.buscarTodosPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }

    @Override
    public List<T> buscarTudo() throws ServiceExcecoes{
        try {
            return dao.buscarTudo();
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }
}
