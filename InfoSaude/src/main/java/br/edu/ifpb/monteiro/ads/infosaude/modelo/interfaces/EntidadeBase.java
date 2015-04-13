package br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 04/04/2015
 */
public interface EntidadeBase <T> extends Serializable {

    static final long serialVersionUID = 1L;

    public Long getId();
    

   
    
    
}
