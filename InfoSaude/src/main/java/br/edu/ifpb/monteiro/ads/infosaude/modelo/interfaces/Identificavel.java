package br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces;

import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 04/04/2015
 */
public interface Identificavel <T> extends Serializable {

    static final long serialVersionUID = 1L;

    public Long getId();
   
    
}
