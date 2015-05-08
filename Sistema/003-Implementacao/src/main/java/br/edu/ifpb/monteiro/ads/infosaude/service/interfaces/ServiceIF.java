package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.List;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public interface ServiceIF<T> {

    T salvar(T identificadorGenerico) throws ServiceExcecoes;

    T atualizar(T identificadorGenerico) throws ServiceExcecoes;

    void remover(T identificadorGenerico) throws ServiceExcecoes;

    T consultarPorId(Long id) throws ServiceExcecoes;

    T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes;

    List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes;

    List<T> buscarTudo() throws ServiceExcecoes;

}
