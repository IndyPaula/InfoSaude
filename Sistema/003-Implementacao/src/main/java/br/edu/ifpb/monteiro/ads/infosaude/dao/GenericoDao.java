package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.DaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.List;
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
public class GenericoDao<T extends Identificavel> implements Serializable, DaoIF<T> {

    private static final Long serialVersionUID = 1L;

    private Class<T> classePersistente;

    @Inject
    private EntityManager em;

    public GenericoDao(Class<T> clazz) {
        this.classePersistente = clazz;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public GenericoDao() {
    }

    @Override
    public T salvar(T identificadorGenerico) throws DaoExcecoes {
        if (identificadorGenerico.getId() == null) {
            em.persist(identificadorGenerico);
        }
        return identificadorGenerico;
    }

    @Override
    public T atualizar(T identificadorGenerico) throws DaoExcecoes {
        if (identificadorGenerico.getId() != null) {
            em.merge(identificadorGenerico);
        }
        return identificadorGenerico;
    }

    @Override
    public void remover(T identificadorGenerico) throws DaoExcecoes {
        if (identificadorGenerico.getId() == null) {
            identificadorGenerico = consultarPorId(identificadorGenerico.getId());
            em.remove(identificadorGenerico);
        }
    }

    @Override
    public T consultarPorId(Long id) throws DaoExcecoes {
        T identificadorGenerico = null;
        identificadorGenerico = em.find(classePersistente, id);
        return identificadorGenerico;
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) throws DaoExcecoes {

        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(classePersistente);

            Root<T> root = createQuery.from(classePersistente);

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

            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(classePersistente);

            Root<T> root = createQuery.from(classePersistente);

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
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(classePersistente));
        return em.createQuery(cq).getResultList();
    }
}
