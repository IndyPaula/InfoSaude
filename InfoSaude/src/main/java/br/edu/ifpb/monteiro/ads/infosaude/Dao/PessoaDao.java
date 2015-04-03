package br.edu.ifpb.monteiro.ads.infosaude.Dao;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 03/04/2015
 */
public class PessoaDao {

    public EntityManager getEM () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InfoSaudePU");
        return emf.createEntityManager();
    }
    
    public void salvar (Pessoa pessoa) {
        EntityManager em = getEM();
        em.persist(pessoa);
    }
    
}
