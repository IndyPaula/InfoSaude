package br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 13/04/2015
 */
public class DaoExcecoes extends Exception {

    /**
     * Creates a new instance of <code>DaoExcecoes</code> without detail message.
     */
    public DaoExcecoes() {
    }


    /**
     * Constructs an instance of <code>DaoExcecoes</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DaoExcecoes(String msg) {
        super(msg);
    }
    
    
      public DaoExcecoes(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
