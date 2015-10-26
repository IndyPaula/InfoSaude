package br.edu.ifpb.monteiro.ads.infosaude.dao;

import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.ControleEstoqueVacinaDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ControleEstoqueVacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import javax.persistence.Query;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public class ControleEstoqueVacinaDao extends GenericoDao<ControleEstoqueVacina> implements ControleEstoqueVacinaDaoIF {

    public ControleEstoqueVacinaDao() {
        super(ControleEstoqueVacina.class);
    }

    @Override
    public int quantidadeDeVacina(Vacina vacina) throws DaoExcecoes {

        int resultadoDoRetorno;
        Long valor = vacina.getId();
        String consulta = "select vacina_quantidade_estoque(" + valor + ")";
        Query singleResult = getEntityManager().createNativeQuery(consulta);
        if (singleResult.getResultList().isEmpty()) {
            resultadoDoRetorno = Integer.parseInt(singleResult.getSingleResult().toString());
            if (resultadoDoRetorno > 0) {
                return resultadoDoRetorno;
            } else {
                return 0;
            }
        } else {
            return vacina.getQuantidadeDosesRecebidas();
        }
    }

}
