package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerUtil;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <T>
 * @date 04/04/2015
 */
public class GenericoDao<T extends EntidadeBase> implements Serializable {

    @PersistenceContext(unitName = "InfoSaudePU")
    private EntityManager em;

    private Class<T> classePersistente;

    public GenericoDao(Class<T> clazz) {
        this.classePersistente = clazz;
        this.em = EntityManagerUtil.getInstance();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public Class<T> getClassePersistente() {
        return classePersistente;
    }

    public boolean salvar(T identificadorGenerico) throws DaoExcecoes {
        Boolean result = false;
        try {
            em.getTransaction().begin();
            if (identificadorGenerico.getId() == null) {
                em.persist(identificadorGenerico);
                em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DaoExcecoes(e.getMessage(), e);
        } finally {
            em.close();
        }
        return true;
    }

    public Boolean atualizar(T identificadorGenerico) throws DaoExcecoes {
        Boolean result = false;
        try {
            em.getTransaction().begin();
            if (identificadorGenerico.getId() != null) {
                em.merge(identificadorGenerico);
                em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            if (!em.contains(identificadorGenerico)) {
                if (em.find(identificadorGenerico.getClass(), identificadorGenerico.getId()) == null) {
                    throw new DaoExcecoes("Erro ao persistir " + identificadorGenerico, e);
                }
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Boolean remover(Long id) throws DaoExcecoes {
        T identificadorGenerico = em.find(classePersistente, id);
        Boolean result = false;
        try {
            em.getTransaction().begin();;
            em.remove(identificadorGenerico);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            throw new DaoExcecoes("Erro ao remover " + identificadorGenerico, e);
        } finally {
            em.close();
        }
        return result;

    }

    public T consultarPorId(Long id) throws DaoExcecoes {
        T identificadorGenerico = null;
        try {
            identificadorGenerico = em.find(classePersistente, id);
        } catch (Exception e) {
            throw new DaoExcecoes("Erro ao buscar por " + identificadorGenerico, e);
        } finally {
            em.close();
        }
        return identificadorGenerico;
    }

    public List<T> buscarTudo() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(classePersistente));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
