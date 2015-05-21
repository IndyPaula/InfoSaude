package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory entityManagerFactory;

    public EntityManagerProducer() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("InfoSaudePU");
    }

    public EntityManagerProducer(String unidadePersistencia) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(unidadePersistencia);
    }
    @Produces
    @RequestScoped
    public EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }
    
    public void close(@Disposes EntityManager entityManager) {
        entityManager.close();
    }
    
}