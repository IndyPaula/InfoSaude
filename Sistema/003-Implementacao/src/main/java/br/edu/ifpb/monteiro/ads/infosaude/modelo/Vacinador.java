package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "vacinador")
public class Vacinador extends Funcionario implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "coren", nullable = false, unique = true, length = 15)
    private int coren;

    public int getCoren() {
        return coren;
    }

    public void setCoren(int coren) {
        this.coren = coren;
    }

}
