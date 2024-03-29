package br.edu.ifpb.monteiro.ads.infosaude.webservices;

import br.edu.ifpb.monteiro.ads.infosaude.dao.ACSDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.UnidadeSaudeDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.VacinadorDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.EntityManagerProducer;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.ACS;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.util.List;
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
@WebService(serviceName = "InfoSaudeWS")
public class InfoSaudeWS {

    private EntityManagerProducer emp;
    private EntityManager em;
    private UnidadeSaudeDao daoUbs;
    private VacinadorDao daoVacinador;
    private ACSDao daoAcs;

    public InfoSaudeWS() {

    }

    private void preparaDao() {
        daoUbs = new UnidadeSaudeDao();
        daoVacinador = new VacinadorDao();
        daoAcs = new ACSDao();

        emp = new EntityManagerProducer();
        em = emp.create();
        daoUbs.setEntityManager(em);
        daoVacinador.setEntityManager(em);
        daoAcs.setEntityManager(em);
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        System.err.println("TESTANDO WEB SERVICES SOAP, BEM VINDO " + txt);
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
            Logger.getLogger(InfoSaudeWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Retorna as os vacinadores da UBS
     *
     * @return
     */
    @WebMethod(operationName = "vacinadoresUBS")
    public List<Vacinador> vacinadoresUBS() {
        try {
            preparaDao();
            return daoVacinador.buscarTudo();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(InfoSaudeWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Retorna os agentes comunitários de Saúde da UBS
     *
     * @return
     */
    @WebMethod(operationName = "acsUBS")
    public List<ACS> acsUBS() {
        try {
            preparaDao();
            return daoAcs.buscarTudo();
        } catch (DaoExcecoes ex) {
            Logger.getLogger(InfoSaudeWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   @WebMethod(operationName = "insertAtendimento")
    public String insertCliente(@WebParam(name = "id")  Long id,
                                                @WebParam(name = "dataAtendimento") String dataAtendimento,
                                                @WebParam(name = "paciente") String paciente,
                                                @WebParam(name = "motivoVisita") String motivoVisita,
                                                @WebParam(name = "acsResponsavel") String acsResponsavel, 
                                                @WebParam(name = "cartaoSus")   String cartaoSus,
                                                @WebParam(name = "gestante")  String gestante, 
                                                @WebParam(name = "puerpera") String puerpera,
                                                @WebParam(name = "recemNascido") String recemNascido,
                                                @WebParam(name = "crianca") String crianca,
                                                @WebParam(name = "desnutricao") String desnutricao,
                                                @WebParam(name = "reabilitacaoDeficiencia") String reabilitacaoDeficiencia,
                                                @WebParam(name = "hipertensao") String hipertensao,
                                                @WebParam(name = "diabetes") String diabetes,
                                                @WebParam(name = "asma") String asma,
                                                @WebParam(name = "dpocEnfisema") String dpocEnfisema,
                                                @WebParam(name = "cancer") String cancer,
                                                @WebParam(name = "outrasDoencasCronicas") String outrasDoencasCronicas,
                                                @WebParam(name = "hanseniase") String hanseniase,
                                                @WebParam(name = "tuberculose") String tuberculose,
                                                @WebParam(name = "domiciliadosAcamados") String domiciliadosAcamados,
                                                @WebParam(name = "vunerabilidadeSocial") String vunerabilidadeSocial,
                                                @WebParam(name = "bolsaFamilia") String bolsaFamilia,
                                                @WebParam(name = "saudeMental") String saudeMental,
                                                @WebParam(name = "usuarioAlcool") String usuarioAlcool,
                                                @WebParam(name = "usuarioDrogas") String usuarioDrogas) {

        System.err.println("ASMA:  "+asma);
        System.err.println("DIABETES:  "+diabetes);
        
        return "Vamos lá";

    }
}
