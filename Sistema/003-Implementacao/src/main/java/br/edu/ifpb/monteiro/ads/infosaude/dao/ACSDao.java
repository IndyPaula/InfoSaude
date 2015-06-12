package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ACSDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.service.VacinadorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
public class ACSDao extends GenericoDao<ACS> implements ACSDaoIF {

    public ACSDao() {
        super(ACS.class);
    }

   @Override
    public void remover(ACS entity) {

        Query queryVacinador = getEntityManager().createNativeQuery("DELETE FROM acs WHERE id = " + entity.getId());
        queryVacinador.executeUpdate();
        
        Query queryFuncionario = getEntityManager().createNativeQuery("DELETE FROM funcionario WHERE id = " + entity.getId());
        queryFuncionario.executeUpdate();

        Query queryPessoa = getEntityManager().createNativeQuery("DELETE FROM pessoa WHERE id = " + entity.getId());
        queryPessoa.executeUpdate();

        getEntityManager().getTransaction().commit();

    }
    @Override
    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws DaoExcecoes {

        try {

            Funcionario func = null;

            if (id == null) {

                Query queryAcs = getEntityManager().createNativeQuery(
                        "SELECT * FROM funcionario f, pessoa p WHERE p.id = f.id AND " + campo + " = '" + valor + "' ", Funcionario.class);
                
                func = (Funcionario) queryAcs.getSingleResult();

                if (func != null) {

                    throw new DaoExcecoes("O " + campo.toUpperCase() + " informado pertence a outra pessoa, por favor informe outro.");
                }
            } else {
                
                Query queryAcs = getEntityManager().createNativeQuery(
                        "SELECT * FROM funcionario f,  pessoa p WHERE p.id = f.id AND " + campo + " = '" + valor + "' ", Funcionario.class);
                
                func = (Funcionario) queryAcs.getSingleResult();
                
                if (func != null && id != func.getId()) {

                    throw new DaoExcecoes("O " + campo.toUpperCase() + " informado pertence a outra pessoa, por favor informe outro.");
                }

                return true;
            }
        } catch (NoResultException ex) {

            Logger.getLogger(VacinadorService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;

    }

}
