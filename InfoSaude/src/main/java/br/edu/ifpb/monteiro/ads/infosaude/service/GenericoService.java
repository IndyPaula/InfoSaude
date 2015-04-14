package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public abstract class GenericoService<T extends Identificavel> implements ServiceIF<T> {
    
    public abstract DaoIF getDao();

    @Override
    public boolean salvar(T entidadeBase) throws ServiceExcecoes {
        try {
            getDao().salvar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Salvar", ex);
        }
    }

    @Override
    public boolean atualizar(T entidadeBase) throws ServiceExcecoes {
        try {
            getDao().atualizar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Atualizar", ex);
        }
    }

    @Override
    public boolean remover(Long id) throws ServiceExcecoes {
        try {
            getDao().remover(id);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Remover", ex);
        }
    }

    @Override
    public T consultarPorId(Long id) throws ServiceExcecoes {
        try {
            return (T) getDao().consultarPorId(id);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Consultar por ID", ex);
        }
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return (T) getDao().buscarPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar por Campo", ex);
        }
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return getDao().buscarTodosPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }

    @Override
    public List<T> buscarTudo() throws ServiceExcecoes{
        try {
            return getDao().buscarTudo();
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Buscar Todos", ex);
        }
    }
}
