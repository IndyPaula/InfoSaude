package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public interface DaoIF<T> {

    boolean salvar(T entidadeBase) throws DaoExcecoes;

    boolean atualizar(T entidadeBase) throws DaoExcecoes;

    boolean remover(Long id) throws DaoExcecoes;

    T consultarPorId(Long id) throws DaoExcecoes;

    T buscarPorCampo(String campo, Object valor) throws DaoExcecoes;

    List<T> buscarTodosPorCampo(String campo, Object valor) throws DaoExcecoes;

    List<T> buscarTudo() throws DaoExcecoes;

}
