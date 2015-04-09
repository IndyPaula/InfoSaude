package br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces;

import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 04/04/2015
 */
public interface EntidadeBase extends Serializable {

   public Long getId();

//    @Override
//    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();

   
   
   
}
