package br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 01/05/2015
 */
public class BeanExcecao extends Exception {

    /**
     * Creates a new instance of <code>BeanExcecao</code> without detail message.
     */
    public BeanExcecao() {
    }


    /**
     * Constructs an instance of <code>BeanExcecao</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BeanExcecao(String msg) {
        super(msg);
    }
}
