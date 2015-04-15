package br.edu.ifpb.monteiro.ads.infosaude.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.spi.container.servlet.ServletContainer;



/**
 *
 * Classe responsável por conter os metodos REST de acesso ao webservice
 *
 */
@Path("/cliente")
public class ClienteResource {

    /**
     *
     * Método responsável por fazer chamada ao controller
     *
     * @return 
     */
    @GET
    @Path("/listarCliente")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarTodos() {
       
        return "Lista de clientes";

    }

//    @POST
//    @Path("/addCliente")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Mensagem addCliente(Cliente cliente) {
//
//        if (ClienteController.addCliente(cliente)) {
//
//            return new Mensagem("Adicionado");
//
//        } else {
//            return new Mensagem("Erro");
//        }
//
//    }

    /***
     * Buscar registro por ID, 
     * Exemplo de URL: http://localhost:10000/WebServiceRestFull/cliente/10
     * @param id
     * @return 
     */
    
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Cliente getClienteById(@PathParam("id") Integer id) {
//
//        //IMPLEMENTAR FIND BY ID
//        Cliente c = new Cliente();
//        c.setId(id);
//        c.setNome("Vander");
//        
//        return c;
//    }

}
