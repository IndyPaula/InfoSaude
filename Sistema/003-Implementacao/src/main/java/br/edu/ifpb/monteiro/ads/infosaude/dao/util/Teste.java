package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import br.edu.ifpb.monteiro.ads.infosaude.dao.LoginAdminDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.UnidadeSaudeDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.interfaces.UnidadeSaudeDaoIF;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author vanderlan
 */
public class Teste {

    static UnidadeSaudeDao dao = new UnidadeSaudeDao();

    public static void main(String[] args)  {

        EntityManagerProducer emp = new EntityManagerProducer();

        EntityManager em = emp.create();

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm = new LoginAdmin();

        adm.setLogin("JUNIT-TEST-USER-TO-LOGIN");
        adm.setSenhaAdm("202cb962ac59075b964b07152d234b70");

        UnidadeSaude ubs = new UnidadeSaude();

        ubs.setBairro("diwdj");
        ubs.setCep("645645654");
        ubs.setCidade("Monteiro");
        ubs.setCnes(123);
        ubs.setEnderecoNumero(23);
        ubs.setEstado(EnumEstados.AC);
        ubs.setLogradouro("erneowirew");
        ubs.setNome("UBS 9");
        ubs.setNumero(9);
        
        dao.setEm(em);

        try {
            dao.getEntityManager().getTransaction().begin();
            dao.salvar(ubs);
            
            dao.getEntityManager().getTransaction().commit();
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
