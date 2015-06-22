package br.edu.ifpb.monteiro.ads.infosaude.webservices;

import br.edu.ifpb.monteiro.ads.infosaude.dao.UnidadeSaudeDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;

/**
 * @date 11/06/2015
 * @author Vanderlan Gomes
 */
@WebService(serviceName = "InfomacoesUbsWS")
public class InfomacoesUbsWS {

    private EntityManagerProducer emp;
    private EntityManager em;
    private UnidadeSaudeDao daoUbs;

    public InfomacoesUbsWS() {

    }

    private void preparaDao() {
        daoUbs = new UnidadeSaudeDao();

        emp = new EntityManagerProducer();
        em = emp.create();
        daoUbs.setEntityManager(em);
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {

        return "TESTANDO WEB SERVICES SOAP, BEM VINDO " + txt;
    }

    /**
     * Retorna as informações da UBS
     *
     * @return
     */
    @WebMethod(operationName = "dadosUBS")
    public UnidadeSaude dadosUBS() {
        try {
            preparaDao();
            return daoUbs.obterInstancia();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(InfomacoesUbsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
