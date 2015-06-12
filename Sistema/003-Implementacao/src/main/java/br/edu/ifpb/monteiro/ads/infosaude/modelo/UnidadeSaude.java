package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
@Entity(name = "unidade_saude")
@SequenceGenerator(name = "unidade_saude_seq", sequenceName = "unidade_saude_seq", initialValue = 1, allocationSize = 1)
public class UnidadeSaude implements Identificavel<UnidadeSaude>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "unidade_saude_seq")
    private Long id;

    @Column(name = "cnes", unique = true, nullable = false)
    private Integer cnes;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "endereco_logradouro", nullable = false, length = 80)
    private String logradouro;

    @Column(name = "endereco_numero", nullable = false)
    private Integer enderecoNumero;

    @Column(name = "endereco_cep", nullable = false, length = 10)
    private String cep;

    @Column(name = "endereco_bairro", nullable = false, length = 80)
    private String bairro;

    @Column(name = "endereco_cidade", nullable = false, length = 30)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_estado", nullable = false, length = 30)
    private EnumEstados estado;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCnes() {
        return cnes;
    }

    public void setCnes(Integer cnes) {
        this.cnes = cnes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public EnumEstados getEstado() {
        return estado;
    }

    public void setEstado(EnumEstados estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
