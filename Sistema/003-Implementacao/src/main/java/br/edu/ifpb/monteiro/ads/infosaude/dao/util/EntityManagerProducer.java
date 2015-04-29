package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class EntityManagerProducer {

    private static EntityManager em = getEntityManager();

    private static EntityManager getEntityManager() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");

        return emf.createEntityManager();
    }

    public static EntityManager getInstance() {

        return em;
    }

}
