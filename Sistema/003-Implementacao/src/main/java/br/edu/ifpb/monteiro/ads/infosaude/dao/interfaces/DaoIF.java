package br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public interface DaoIF<T> {

    T salvar(T identificadorGenerico) throws DaoExcecoes;

    T atualizar(T identificadorGenerico) throws DaoExcecoes;

    void remover(T identificadorGenerico) throws DaoExcecoes;

    T consultarPorId(Long id) throws DaoExcecoes;

    T buscarPorCampo(String campo, Object valor) throws DaoExcecoes;

    List<T> buscarTodosPorCampo(String campo, Object valor) throws DaoExcecoes;

    List<T> buscarTudo() throws DaoExcecoes;

}
