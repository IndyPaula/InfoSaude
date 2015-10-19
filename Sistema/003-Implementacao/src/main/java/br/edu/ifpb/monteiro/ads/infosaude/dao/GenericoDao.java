package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 04/04/2015
 */
public abstract class GenericoDao<T extends Identificavel> implements Serializable, DaoIF<T> {

    @Inject
    private transient EntityManager entityManager;

    private Class<T> entity;

    public GenericoDao(Class<T> clazz) {
        this.entity = clazz;
    }

    public Class<T> getEntity() {
        return entity;
    }

    public void setEntity(Class<T> entity) {
        this.entity = entity;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T salvar(T entity) throws DaoExcecoes {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T atualizar(T entity) throws DaoExcecoes {
        entityManager.merge(entity);
        return entity;
    }

    @Override
    public void remover(T entity) throws DaoExcecoes {
        entityManager.remove(entity);
    }

    @Override
    public T consultarPorId(Long id) throws DaoExcecoes {

        return entityManager.find(this.entity, id);

    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws DaoExcecoes {

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);

            Root<T> root = createQuery.from(entity);

            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));

            createQuery.where(predicate);

            return entityManager.createQuery(createQuery).getSingleResult();

        } catch (NoResultException ex) {
            Logger.getLogger(GenericoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws DaoExcecoes {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);

        Root<T> root = createQuery.from(entity);

        Predicate predicate = criteriaBuilder.conjunction();
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));

        createQuery.where(predicate);

        return entityManager.createQuery(createQuery).getResultList();

    }

    @Override
    public List<T> buscarTudo() throws DaoExcecoes {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));
        return entityManager.createQuery(cq).getResultList();
    }
}
