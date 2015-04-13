package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.GenericoDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ServiceIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class GenericoService<T extends EntidadeBase> implements ServiceIF {

   

    @Override
    public boolean salvar(EntidadeBase entidadeBase) throws ServiceExcecoes {
        try {
            dao.salvar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao Salvar", ex);
        }
        return true;
    }

    @Override
    public boolean atualizar(EntidadeBase entidadeBase) throws ServiceExcecoes {
        try {
            dao.atualizar(entidadeBase);
            return true;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao Atualizar", ex);
        }
        return true;
    }

    @Override
    public boolean remover(Long id) throws ServiceExcecoes {
        try {
            dao.remover(id);
            return true;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao Remover", ex);
        }
        return true;
    }

    @Override
    public EntidadeBase consultarPorId(Long id) throws ServiceExcecoes {
        EntidadeBase base = null;
        try {
            base = dao.consultarPorId(id);
            return base;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao consultarPorId", ex);
        }
        return base;
    }

    @Override
    public EntidadeBase buscarPorCampo(String campo, Object valor) throws ServiceExcecoes {
        EntidadeBase base = null;
        try {
            base = dao.buscarPorCampo(campo, valor);
            return base;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao consultarPorId", ex);
        }
        return base;
    }

    @Override
    public List<EntidadeBase> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes {
        List<EntidadeBase> base = null;
        try {
            base = dao.buscarTodosPorCampo(campo, valor);
            return base;
        } catch (DaoExcecoes ex) {
            new ServiceExcecoes("Erro no service ao consultarPorId", ex);
        }
        return base;
    }

    @Override
    public List<EntidadeBase> buscarTudo() {
       return dao.buscarTudo();
    }

}
