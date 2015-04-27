package br.edu.ifpb.monteiro.ads.infosaude.service;

import br.edu.ifpb.monteiro.ads.infosaude.dao.ACSDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ACSDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.ACSServiceIF;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class ACSService extends GenericoService<ACS> implements ACSServiceIF {

    private ACSDaoIF dao;

    public ACSService() {
        this.dao = new ACSDao();
    }

}
