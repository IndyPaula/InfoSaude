package br.edu.ifpb.monteiro.ads.infosaude.service.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import java.util.List;


/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public interface ServiceIF {

       boolean salvar(EntidadeBase entidadeBase) throws ServiceExcecoes;
       
       boolean atualizar(EntidadeBase entidadeBase) throws ServiceExcecoes;
       
       boolean remover(Long id) throws ServiceExcecoes;
       
       EntidadeBase consultarPorId(Long id) throws ServiceExcecoes;
       
       EntidadeBase buscarPorCampo(String campo, Object valor) throws ServiceExcecoes;
       
       List<EntidadeBase> buscarTodosPorCampo(String campo, Object valor) throws ServiceExcecoes;
       
       List<EntidadeBase> buscarTudo();
       
}
