package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "vacinador")
@SequenceGenerator(name = "vacinador_seq", sequenceName = "vacinador_seq", initialValue = 1, allocationSize = 1)
public class Vacinador implements EntidadeBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vacinador_seq")
    private Long id;
    
    @Column(name = "registro_coren", nullable = false, unique = true)
    private int registroCoren;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;

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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacinador other = (Vacinador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
