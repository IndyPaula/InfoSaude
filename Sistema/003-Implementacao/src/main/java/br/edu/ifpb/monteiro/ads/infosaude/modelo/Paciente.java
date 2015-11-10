package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private Integer numeroProntuario;

    @Column(name = "cartao_sus", nullable = true, length = 15, unique = true)
    private String cartaoSUS;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "cpf", nullable = false, length = 14, unique = true, precision = 14)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    @JoinColumn(name = "atendimento_imunizacao_id")
    private List<AtendimentoImunizacao> imunizacaos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    @JoinColumn(name = "atendimento_domiciliar_id")
    private List<AtendimentoDomiciliar> atendimentos;

    public Integer getNumeroProntuario() {
        return numeroProntuario;
    }

    public List<AtendimentoDomiciliar> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<AtendimentoDomiciliar> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void setNumeroProntuario(Integer numeroProntuario) {
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

    public List<AtendimentoImunizacao> getImunizacaos() {
        return imunizacaos;
    }

    public void setImunizacaos(List<AtendimentoImunizacao> imunizacaos) {
        this.imunizacaos = imunizacaos;
    }

}
