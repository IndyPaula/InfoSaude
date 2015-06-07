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
//        buscarVacinador();
//        crip();
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
        v.setSenha(CriptografiaUtil.convertStringToMd5("123"));
        v.setCodigoEquipeINE("4234");
        v.setAdm("s");

        Vacinador v2 = new Vacinador();

        v2.setNome("Vanderlan");
        v2.setCpf("42342678342");
        v2.setDataNascimento(new Date());
        v2.setMatricula(421);
        v2.setCoren(1345);
        v2.setLogin("Vanderlan");
        v2.setSenha(CriptografiaUtil.convertStringToMd5("123"));
        v2.setCodigoEquipeINE("414");
        v2.setAdm("s");

        Vacinador v3 = new Vacinador();

        v3.setNome("Vacinador Alves");
        v3.setCpf("42342842342");
        v3.setDataNascimento(new Date());
        v3.setMatricula(4291);
        v3.setCoren(134599);
        v3.setLogin("Vacinador");
        v3.setSenha(CriptografiaUtil.convertStringToMd5("123"));
        v3.setCodigoEquipeINE("41489");
        v3.setAdm("s");

        Vacinador v4 = new Vacinador();

        v4.setNome("Vacinador Gomes");
        v4.setCpf("42342842490");
        v4.setDataNascimento(new Date());
        v4.setMatricula(429143);
        v4.setCoren(199);
        v4.setLogin("Gomes");
        v4.setSenha(CriptografiaUtil.convertStringToMd5("123"));
        v4.setCodigoEquipeINE("41489");
        v4.setAdm("s");

        try {
            daoVacinador.getEntityManager().getTransaction().begin();
            daoVacinador.salvar(v);
            daoVacinador.salvar(v2);
            daoVacinador.salvar(v4);
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

    private static void crip() {

        System.err.println(CriptografiaUtil.convertStringToMd5("123"));

        System.err.println(CriptografiaUtil.convertStringToMd5(CriptografiaUtil.convertStringToMd5("123")));

        System.err.println(CriptografiaUtil.convertStringToMd5(
                CriptografiaUtil.convertStringToMd5(CriptografiaUtil.convertStringToMd5("123"))));

    }
}
