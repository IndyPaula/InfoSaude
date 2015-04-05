package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
@Entity(name = "paciente")
@SequenceGenerator(name = "paciente_seq", sequenceName = "paciente_seq", initialValue = 1, allocationSize = 1)
public class Paciente implements Serializable, EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "paciente_seq")
    private Long id;

    @Column(name = "paciente_numero_prontuario", nullable = false, unique = true)
    private int pacienteNumeroProntuario;

    @Temporal(TemporalType.DATE)
    @Column(name = "paciente_data_cadastro", nullable = false)
    private Date pacienteDataCadastro;

    @Column(name = "pessoa_cartao_sus", nullable = false, length = 15, unique = true)
    private String cartaoSUS;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    
    @Override
    public Long getId() {
        return id;
    }

    public int getPacienteNumeroProntuario() {
        return pacienteNumeroProntuario;
    }

    public void setPacienteNumeroProntuario(int pacienteNumeroProntuario) {
        this.pacienteNumeroProntuario = pacienteNumeroProntuario;
    }

    public Date getPacienteDataCadastro() {
        return pacienteDataCadastro;
    }

    public void setPacienteDataCadastro(Date pacienteDataCadastro) {
        this.pacienteDataCadastro = pacienteDataCadastro;
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    

}
