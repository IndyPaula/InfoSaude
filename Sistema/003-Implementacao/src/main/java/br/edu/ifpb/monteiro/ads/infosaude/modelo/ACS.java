package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "acs")
public class ACS extends Funcionario implements Serializable  {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "cbo", length = 15, nullable = false, unique = true)
    private String cbo;

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
    }

    @Override
    public Long getId() {
        return id;
    }

}
