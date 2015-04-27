package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 13/04/2015
 */
public interface ServiceIF<T> {

    @Transactional
    T salvar(T identificadorGenerico) throws ServiceExcecoes;

    @Transactional
    T atualizar(T identificadorGenerico) throws ServiceExcecoes;

    @Transactional
    void remover(T identificadorGenerico) throws ServiceExcecoes;

    @Transactional
    T consultarPorId(Long id) throws ServiceExcecoes;

    @Transactional
    T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes;

    @Transactional
    List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes;

    @Transactional
    List<T> buscarTudo() throws ServiceExcecoes;

}
