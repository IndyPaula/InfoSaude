package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.EntidadeBase;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 31/03/2015
 */
@Entity(name = "pessoa")
@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", initialValue = 1, allocationSize = 1)
public class Pessoa implements EntidadeBase<Pessoa> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pessoa_seq")
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = true, length = 9)
    private EnumGeneros sexo;

    @Column(name = "nome_mae", nullable = true, length = 80)
    private String nomeMae;

    @Column(name = "nome_pai", nullable = true, length = 80)
    private String nomePai;

    @Enumerated(EnumType.STRING)
    @Column(name = "etnia", nullable = true, length = 20)
    private EnumEtnias etnia;

    @Column(name = "altura", nullable = true, scale = 2)
    private double altura;

    @Column(name = "peso", nullable = true, scale = 2)
    private double peso;

    @Column(name = "cpf", nullable = false, length = 11, unique = true, precision = 11)
    private String cpf;

    @Column(name = "peso_nascer", nullable = true, scale = 2)
    private double pesoNascer;

    @Column(name = "endereco_rua", nullable = true, length = 80)
    private String rua;

    @Column(name = "endereco_numero", nullable = true)
    private int numero;

    @Column(name = "endereco_cep", nullable = true, length = 8)
    private String cep;

    @Column(name = "endereco_bairro", nullable = true, length = 80)
    private String bairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_estado", nullable = true, length = 30)
    private EnumEstados estado;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnumGeneros getSexo() {
        return sexo;
    }

    public void setSexo(EnumGeneros sexo) {
        this.sexo = sexo;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public EnumEtnias getEtnia() {
        return etnia;
    }

    public void setEtnia(EnumEtnias etnia) {
        this.etnia = etnia;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getPesoNascer() {
        return pesoNascer;
    }

    public void setPesoNascer(double pesoNascer) {
        this.pesoNascer = pesoNascer;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
