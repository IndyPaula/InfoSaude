package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
    private EntityManager em;
    
    private Class<T> entity;

    public GenericoDao(Class<T> clazz) {
        this.entity = clazz;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public Class<T> getEntity() {
        return entity;
    }

    public void setEntity(Class<T> entity) {
        this.entity = entity;
    }

    public Class<T> getClassePersistente() {
        return entity;
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public T salvar(T entity) throws DaoExcecoes {
        em.persist(entity);
        return entity;
    }

    @Override
    public T atualizar(T entity) throws DaoExcecoes {
        em.merge(entity);
        return entity;
    }

    @Override
    public void remover(T entity) throws DaoExcecoes {
        em.remove(entity);
    }

    @Override
    public T consultarPorId(Long id) throws DaoExcecoes {
        T entity = em.find(this.entity, id);
        return entity;
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws DaoExcecoes {

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);

            Root<T> root = createQuery.from(entity);

            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));

            createQuery.where(predicate);

            T resultado = em.createQuery(createQuery).getSingleResult();

            return resultado;

        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DaoExcecoes("Informação não encontrada", e);
        }
    }

    @Override
    public List<T> buscarTodosPorCampo(String campo, Object valor) throws DaoExcecoes {
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);

            Root<T> root = createQuery.from(entity);

            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));

            createQuery.where(predicate);

            List<T> resultado = em.createQuery(createQuery).getResultList();

            return resultado;

        } catch (Exception e) {
            throw new DaoExcecoes("Informação não encontrada", e);
        }
    }

    @Override
    public List<T> buscarTudo() throws DaoExcecoes {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select( cq.from(entity));
        return getEntityManager().createQuery(cq).getResultList();
//        Query query = getEntityManager().createQuery("Select t from " + entity.getName() + " t");
//        return query.getResultList();
        
    }

}
