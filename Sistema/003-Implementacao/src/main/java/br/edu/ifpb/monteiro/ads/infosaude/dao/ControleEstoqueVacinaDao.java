package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ControleEstoqueVacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public class ControleEstoqueVacinaDao extends GenericoDao<ControleEstoqueVacina> implements ControleEstoqueVacinaDaoIF {

    public ControleEstoqueVacinaDao() {
        super(ControleEstoqueVacina.class);
    }

}
