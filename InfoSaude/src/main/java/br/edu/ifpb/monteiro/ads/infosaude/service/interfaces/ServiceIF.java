package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.List;


/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public interface ServiceIF<T> {

       boolean salvar(T entidadeBase) throws ServiceExcecoes;
       
       boolean atualizar(T entidadeBase) throws ServiceExcecoes;
       
       boolean remover(Long id) throws ServiceExcecoes;
       
       T consultarPorId(Long id) throws ServiceExcecoes;
       
       T buscarPorCampo(String campo, Object valor) throws ServiceExcecoes;
       
       List<T> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes;
       
       List<T> buscarTudo();
       
}
