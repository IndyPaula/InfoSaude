package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Identificavel<Pessoa>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pessoa_seq")
    private Long id;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Temporal(TemporalType.DATE)
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

    @Column(name = "rg", nullable = true, length = 15, precision = 15)
    private String rg;

    @Column(name = "orgao_emissor", nullable = true, length = 15, precision = 15)
    private String orgaoEmissor;

    @Enumerated(EnumType.STRING)
    @Column(name = "uf_orgao_emissor", nullable = true, length = 15, precision = 15)
    private EnumEstados ufOrgaoEmissor;

    @Column(name = "peso_nascer", nullable = true, scale = 2)
    private double pesoNascer;

    @Column(name = "endereco_logradouro", nullable = true, length = 80)
    private String logradouro;

    @Column(name = "endereco_numero", nullable = true)
    private Integer numero;

    @Column(name = "endereco_cep", nullable = true, length = 10, precision = 10)
    private String cep;

    @Column(name = "endereco_bairro", nullable = true, length = 80)
    private String bairro;

    @Column(name = "endereco_cidade", nullable = true, length = 30)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_estado", nullable = true, length = 30)
    private EnumEstados estado;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public double getPesoNascer() {
        return pesoNascer;
    }

    public void setPesoNascer(double pesoNascer) {
        this.pesoNascer = pesoNascer;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public EnumEstados getUfOrgaoEmissor() {
        return ufOrgaoEmissor;
    }

    public void setUfOrgaoEmissor(EnumEstados ufOrgaoEmissor) {
        this.ufOrgaoEmissor = ufOrgaoEmissor;
    }

    @Override
    public int hashCode() {
        int pessoaHash = 3;
        pessoaHash = 53 * pessoaHash + Objects.hashCode(this.id);
        return pessoaHash;
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
