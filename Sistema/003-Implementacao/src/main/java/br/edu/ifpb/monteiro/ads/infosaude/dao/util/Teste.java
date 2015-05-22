package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import br.edu.ifpb.monteiro.ads.infosaude.dao.LoginAdminDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.LoginAdmin;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author vanderlan
 */
public class Teste {

    static LoginAdminDao dao = new LoginAdminDao();

    public static void main(String[] args)  {

        EntityManagerProducer emp = new EntityManagerProducer();

        EntityManager em = emp.create();

        LoginAdminDao instance = new LoginAdminDao();
        LoginAdmin adm = new LoginAdmin();

        adm.setLogin("user");
        adm.setSenhaAdm("123");

        adm.setMatricula(44234);
        adm.setNome("Vanderlan Gomes");
        adm.setCpf("141.538.432-32");
        adm.setDataNascimento(new Date(2015, 5, 1));
        adm.setCodigoEquipeINE("2423432");
        adm.setSenha("fjhewiufhew");
        adm.setNomeUsuario("fhguwegyf");
        
        dao.setEm(em);

        try {
            dao.getEm().getTransaction().begin();
            dao.salvar(adm);
            
            dao.getEm().getTransaction().commit();
            
        } catch (DaoExcecoes ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
