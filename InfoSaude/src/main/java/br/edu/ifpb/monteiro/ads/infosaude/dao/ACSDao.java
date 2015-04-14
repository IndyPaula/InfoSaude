package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ACSDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class ACSDao extends GenericoDao<ACS> implements ACSDaoIF {

    public ACSDao() {
        super(ACS.class);
    }

}
