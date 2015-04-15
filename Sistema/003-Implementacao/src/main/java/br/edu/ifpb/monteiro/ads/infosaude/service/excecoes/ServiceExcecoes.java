package br.edu.ifpb.monteiro.ads.infosaude.service.excecoes;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class ServiceExcecoes extends Exception {

    /**
     * Creates a new instance of <code>ServiceExcecoes</code> without detail message.
     */
    public ServiceExcecoes() {
    }


    /**
     * Constructs an instance of <code>ServiceExcecoes</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ServiceExcecoes(String msg) {
        super(msg);
    }
    
     public ServiceExcecoes(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
