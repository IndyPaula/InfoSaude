package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class GenericoService<T extends EntidadeBase> implements ServiceIF<T> {
    
    private DaoIF dao;

    @Override
    public boolean salvar(T entidadeBase) throws ServiceExcecoes {
        try {
            dao.salvar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Salvar", ex);
        }
    }

    @Override
    public boolean atualizar(T entidadeBase) throws ServiceExcecoes {
        try {
            dao.atualizar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Atualizar", ex);
        }
    }

    @Override
    public boolean remover(Long id) throws ServiceExcecoes {
        try {
            dao.remover(id);
            return true;
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Remover", ex);
        }
    }

    @Override
    public T consultarPorId(Long id) throws ServiceExcecoes {
        try {
            return (T) dao.consultarPorId(id);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Salvar", ex);
        }
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return (T) dao.buscarPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service ao Salvar", ex);
        }
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes {
        try {
            return dao.buscarTodosPorCampo(campo, valor);
        } catch (DaoExcecoes ex) {
            throw new ServiceExcecoes("Erro no Service nenhum objeto encontrado", ex);
        }
    }

    @Override
    public List<T> buscarTudo() {
        return dao.buscarTudo();
    }
}
