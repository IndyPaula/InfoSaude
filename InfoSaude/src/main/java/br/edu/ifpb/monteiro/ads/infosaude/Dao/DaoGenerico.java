package br.edu.ifpb.monteiro.ads.infosaude.Dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @param <IdentificadorGenerico>
 * @date 04/04/2015
 */
public abstract class DaoGenerico<IdentificadorGenerico extends EntidadeBase> implements Serializable{

    public EntityManager getEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");
        return emf.createEntityManager();
    }

    public Boolean salvar(IdentificadorGenerico identificadorGenerico) throws Exception {
        EntityManager em = getEM();
        Boolean result = false;
        try {
            em.getTransaction().begin();
            if (identificadorGenerico.getId() == null) {
                em.persist(identificadorGenerico); // Persiste a entidade
                em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("Erro ao persistir");
        } finally {
            em.close();
        }
        return true;
    }

    public Boolean atualizar(IdentificadorGenerico identificadorGenerico) throws Exception {
        EntityManager em = getEM();
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
                    throw new Exception("Erro ao atualizar " + identificadorGenerico + " não existe");
                }
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Boolean remover(Class<IdentificadorGenerico> clazz, Long id) {
        EntityManager em = getEM();
        IdentificadorGenerico identificadorGenerico = em.find(clazz, id);
        Boolean result = false;
        try {
            em.getTransaction().begin();;
            em.remove(identificadorGenerico);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {

        } finally {
            em.close();
        }
        return result;

    }

    public IdentificadorGenerico consultarPorId(Class<IdentificadorGenerico> clazz, Long id) {
        EntityManager em = getEM();
        IdentificadorGenerico idetificadorGenerico = null;
        try {
            idetificadorGenerico = em.find(clazz, id);
        } catch (Exception e) {
            
        } finally {
            em.close();
        }
        return idetificadorGenerico;
    }
    
     public List<IdentificadorGenerico> buscarTudo(Class<IdentificadorGenerico> clazz) {
        CriteriaQuery cq = getEM().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clazz));
        return getEM().createQuery(cq).getResultList();
    }
    

}
