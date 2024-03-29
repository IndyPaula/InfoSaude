package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
@Entity(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "matricula", unique = true, nullable = false)
    private Integer matricula;

    @Column(name = "turno", length = 20, nullable = true)
    private String turno;

    @Column(name = "codigo_euipe_ine", length = 15, nullable = false)
    private String codigoEquipeINE;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioResponsavel")
    @JoinColumn(name = "atendimento_domiciliar_id")
    private List<AtendimentoDomiciliar> atendimentos;

    @NotNull
    @Column(name = "cpf", nullable = false, length = 14, unique = true, precision = 11)
    private String cpf;

    @Column(name = "cartaosus", nullable = false, length = 15, unique = true)
    private String cartaosus;

    @OneToOne(cascade = CascadeType.ALL)
    private transient UnidadeSaude unidadeSaude;

    @Column(name = "senha", length = 45, unique = false, nullable = false)
    private String senha;

    @Column(name = "login", length = 45, unique = true, nullable = true)
    private String login;

    @Column(name = "adm", length = 1, nullable = true)
    private String adm;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<AtendimentoDomiciliar> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<AtendimentoDomiciliar> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public String getCodigoEquipeINE() {
        return codigoEquipeINE;
    }

    public void setCodigoEquipeINE(String codigoEquipeINE) {
        this.codigoEquipeINE = codigoEquipeINE;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getCartaosus() {
        return cartaosus;
    }

    public void setCartaosus(String cartaosus) {
        this.cartaosus = cartaosus;
    }
    
}
