package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    private int matricula;

    @Column(name = "turno", length = 20, nullable = true)
    private String turno;

    @Column(name = "codigo_euipe_ine", length = 15, nullable = false)
    private String codigoEquipeINE;

    @NotNull
    @Column(name = "cpf", nullable = false, length = 14, unique = true, precision = 14)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private UnidadeSaude unidadeSaude;

    @Column(name = "nome_usuario", length = 45, unique = true, nullable = false)
    private String nomeUsuario;

    @Column(name = "senha", length = 45, unique = false, nullable = false)
    private String senha;

    @Column(name = "login_admin", length = 45, unique = true, nullable = true)
    private String loginAdmin;

    @Column(name = "senha_admin", length = 45, unique = true, nullable = true)
    private String senhaAdmin;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

}
