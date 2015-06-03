package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import br.edu.ifpb.monteiro.ads.infosaude.dao.VacinadorDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Vanderlan Gomes
 */
public class CriaUsuarios {

    private static EntityManagerProducer emp;
    private static EntityManager em;
    private static VacinadorDao daoVacinador;

    public static void main(String[] args) {

        preparaDao();
        cadastrarVacinador();
        buscarVacinador();

    }

    static void preparaDao() {
        daoVacinador = new VacinadorDao();
        //INSTANCIANDO A CLASSE MANUALMENTE pois não funcionaria com Injeção de dependências
        emp = new EntityManagerProducer();
        em = emp.create();
        //SETANTO ENTITY MANAGER MANUALMENTE
        daoVacinador.setEntityManager(em);

    }

    static void cadastrarVacinador() {

        Vacinador v = new Vacinador();

        v.setNome("InfoSaude");
        v.setCpf("42342342342");
        v.setDataNascimento(new Date());
        v.setMatricula(4321);
        v.setCoren(12345);
        v.setLogin("InfoSaude");
        v.setSenha("123");
        v.setCodigoEquipeINE("4234");
        v.setAdm("s");

        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.getEntityManager().getTransaction().commit();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(CriaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void buscarVacinador() {

        try {
            Vacinador v = daoVacinador.buscarPorCampo("coren", 12345);

            System.err.println(v.getNome());
        } catch (DaoExcecoes ex) {
            Logger.getLogger(CriaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
