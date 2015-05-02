package br.edu.ifpb.monteiro.ads.infosaude.beans.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 01/05/2015
 */
public interface BeanIF<T> {

    String salvar() throws BeanExcecao;

    String atualizar() throws BeanExcecao;

    void remover(T identificavel) throws BeanExcecao;

    T consultarPorId(Long id) throws BeanExcecao;

    T buscarPorCampo(String campo, Object valor) throws BeanExcecao;

    List<T> buscarTodosPorCampo(String campo, Object valor) throws BeanExcecao;

    List<T> buscarTudo() throws BeanExcecao;
}
