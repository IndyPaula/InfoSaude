package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 05/04/2015
 */
@Entity(name = "paciente")
public class Paciente extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "numero_prontuario", nullable = false, unique = true)
    private int numeroProntuario;

    @Column(name = "pessoa_cartao_sus", nullable = false, length = 15, unique = true)
    private String cartaoSUS;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "cpf", nullable = false, length = 14, unique = true, precision = 14)
    private String cpf;

    public int getNumeroProntuario() {
        return numeroProntuario;
    }

    public void setNumeroProntuario(int numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }
    
}
