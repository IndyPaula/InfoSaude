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
@Entity(name = "vacinador")
public class Vacinador extends Funcionario implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "registro_coren", nullable = false, unique = true)
    private int registroCoren;

    @Override
    public Long getId() {
        return id;
    }
    
    public int getRegistroCoren() {
        return registroCoren;
    }

    public void setRegistroCoren(int registroCoren) {
        this.registroCoren = registroCoren;
    }

}
