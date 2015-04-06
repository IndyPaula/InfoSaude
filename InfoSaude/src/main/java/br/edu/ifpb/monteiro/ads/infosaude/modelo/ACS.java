package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.util.Objects;
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
@Entity(name = "acs")
@SequenceGenerator(name = "acs_seq", sequenceName = "acs_seq", initialValue = 1, allocationSize = 1)
public class ACS implements EntidadeBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "acs_seq")
    private Long id;
    
    @Column(name = "acs_cbo", length = 15, nullable = false, unique = true)
    private String cbo;
    
    @OneToOne
    private Funcionario funcionario;

    @Override
    public Long getId() {
        return id;
    }

    public String getCbo() {
        return cbo;
    }

    public void setCbo(String cbo) {
        this.cbo = cbo;
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
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ACS other = (ACS) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
