package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
@Entity(name = "unidade_saude")
@SequenceGenerator(name = "unidade_saude_seq", sequenceName = "unidade_saude_seq", initialValue = 1, allocationSize = 1)
public class UnidadeSaude implements Serializable, EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "unidade_saude_seq")
    private Long id;

    @Column(name = "unidade_saude_cnes", unique = true)
    private int cnes;

    @Column(name = "unidade_saude_nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "unidade_saude_endereco", nullable = true, length = 80)
    private String endereco;

    @Column(name = "unidade_saude_numero", nullable = false, unique = true)
    private int numero;

    @OneToMany(mappedBy = "unidadeSaude", cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Funcionario> funcionarios;

    @Override
    public Long getId() {
        return id;
    }

    public int getCnes() {
        return cnes;
    }

    public void setCnes(int cnes) {
        this.cnes = cnes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
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
        final UnidadeSaude other = (UnidadeSaude) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
