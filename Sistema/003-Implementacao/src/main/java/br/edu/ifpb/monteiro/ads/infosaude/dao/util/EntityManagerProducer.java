package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    private static EntityManagerFactory emf;

    public EntityManagerProducer() {
        this.emf = Persistence.createEntityManagerFactory("InfoSaudePU");
    }

    @Produces
    @RequestScoped
    public EntityManager criarEntityMAnager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("InfoSaudePU");
        }

        return this.emf.createEntityManager();
    }

    public void fecharEntityManager(@Disposes EntityManager em) {
        em.close();
    }

}
