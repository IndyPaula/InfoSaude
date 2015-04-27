package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
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
 * @date 05/04/2015
 */
@Entity(name = "funcionario")
@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", initialValue = 1, allocationSize = 1)
public class Funcionario implements Identificavel<Funcionario>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "funcionario_seq")
    private Long id;

    @Column(name = "matricula", unique = true, nullable = false)
    private int matricula;

    @Column(name = "turno", length = 20, nullable = true)
    private String turno;

    @Column(name = "codigo_euipe_ine", length = 15, nullable = false)
    private String codigoEquipeINE;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToOne(cascade = CascadeType.ALL)
    private UnidadeSaude unidadeSaude;

    @Column(name = "nome_usuario", length = 45, unique = true, nullable = false)
    private String nomeUsuario;

    @Column(name = "senha", length = 45, unique = false, nullable = false)
    private String senha;

    @Override
    public Long getId() {
        return id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCodigoEquipeINE() {
        return codigoEquipeINE;
    }

    public void setCodigoEquipeINE(String codigoEquipeINE) {
        this.codigoEquipeINE = codigoEquipeINE;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
