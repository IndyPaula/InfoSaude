package br.edu.ifpb.monteiro.ads.infosaude.webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vanderlan Gomes
 */
@WebService(serviceName = "InfomacoesUbs")
public class InfomacoesUbs {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        return "TESTANDO WEB SERVICES SOAP, BEM VINDO  "+txt;
    }
}
