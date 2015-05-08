package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.Transactional;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public abstract class GenericoService<T extends Identificavel> implements Serializable, ServiceIF<T> {

    private static final Long serialVersionUID = 1L;

    public abstract DaoIF getDao();

    public GenericoService() {
    }

    @Override
    @Transactional
    public T salvar(T identificadorGenerico) throws ServiceExcecoes {
        try {
            getDao().salvar(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identificadorGenerico;
    }

    @Override
    @Transactional
    public T atualizar(T identificadorGenerico) throws ServiceExcecoes {
        try {
            getDao().atualizar(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identificadorGenerico;
    }

    @Override
    @Transactional
    public void remover(T identificadorGenerico) throws ServiceExcecoes {
        try {
            getDao().remover(identificadorGenerico);
        } catch (DaoExcecoes ex) {
            Logger.getLogger(GenericoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @Transactional
    public T consultarPorId(Long id) throws ServiceExcecoes {
        try {
            return (T) getDao().consultarPorId(id);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Consultar por ID", ex);
        }
    }

    @Override
    @Transactional
    public T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return (T) getDao().buscarPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {

            throw new ServiceExcecoes("Erro no Service ao Buscar por Campo", ex);

        }
    }

    @Override
    @Transactional
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return getDao().buscarTodosPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }

    @Override
    @Transactional
    public List<T> buscarTudo() throws ServiceExcecoes {
        try {
            return getDao().buscarTudo();
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }
}
