package br.edu.ifpb.monteiro.ads.infosaude.modelo;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 31/03/2015
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(name = "pessoa_nome", nullable = false, length = 80)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pessoa_data_nascimento", nullable = false)
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_sexo", nullable = true, length = 9)
    private String sexo;

    @Column(name = "pessoa_nome_mae", nullable = true, length = 80)
    private String nomeMae;

    @Column(name = "pessoa_nome_pai", nullable = true, length = 80)
    private String nomePai;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_etnia", nullable = true, length = 20)
    private String etnia;

    @Column(name = "pessoa_altura", nullable = true, precision = 2)
    private double altura;

    @Column(name = "pessoa_peso", nullable = true, precision = 2)
    private double peso;

    @Column(name = "pessoa_cartao_sus", nullable = false, length = 15)
    private String cartaoSUS;

    @Column(name = "pessoa_cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "pessoa_peso_nascer", nullable = true, precision = 2)
    private double pesoNascer;

    @Column(name = "pessoa_endereco_rua", nullable = true, length = 80)
    private String rua;

    @Column(name = "pessoa_endereco_numero", nullable = true)
    private int numero;

    @Column(name = "pessoa_endereco_cep", nullable = true, length = 8)
    private String cep;

    @Column(name = "pessoa_endereco_bairro", nullable = true, length = 80)
    private String bairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_endereco_estado", nullable = true, length = 30)
    private String estado;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
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

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idPessoa);
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
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }

}
