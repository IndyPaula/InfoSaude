package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 15/04/2015
 */
@Entity(name = "atendimento_domiciliar")
public class AtendimentoDomiciliar implements Identificavel<AtendimentoDomiciliar>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_atendimento", nullable = false)
    private Date dataAtendimento;

     @ManyToOne
    private Paciente paciente;

    @Column(name = "motivo_visita", length = 45)
    private String motivoVisita;

    @ManyToOne
    private ACS acs;

    @ManyToOne
    private Funcionario funcionarioResponsavel;

    @Column(name = "cartao_sus", length = 15)
    private String cartaoSus;

    //acompanhamento 
    @Column(name = "gestante", length = 1)
    private String gestante;

    @Column(name = "puerpera", length = 1)
    private String puerpera;

    @Column(name = "recem_nascido", length = 1)
    private String recemNascido;

    @Column(name = "crianca", length = 1)
    private String crianca;

    @Column(name = "desnutricao", length = 1)
    private String desnutricao;

    @Column(name = "reabilitacao_deficiencia", length = 1)
    private String reabilitacaoDeficiencia;

    @Column(name = "hipertensao", length = 1)
    private String hipertensao;

    @Column(name = "diabetes", length = 1)
    private String diabetes;

    @Column(name = "asma", length = 1)
    private String asma;

    @Column(name = "dpoc_enfisema", length = 1)
    private String dpocEnfisema;

    @Column(name = "cancer", length = 1)
    private String cancer;

    @Column(name = "outras_doencas_cronicas", length = 1)
    private String outrasDoencasCronicas;

    @Column(name = "hanseniase", length = 1)
    private String hanseniase;

    @Column(name = "tuberculose", length = 1)
    private String tuberculose;

    @Column(name = "domiciliados_acamados", length = 1)
    private String domiciliadosAcamados;

    @Column(name = "vulnerabilidade_social", length = 1)
    private String vulnerabilidadeSocial;

    @Column(name = "bolsa_familia", length = 1)
    private String bolsaFamilia;

    @Column(name = "saude_mental", length = 1)
    private String saudeMental;

    @Column(name = "usuario_alcool", length = 1)
    private String usuarioAlcool;

    @Column(name = "usuario_drogas", length = 1)
    private String usuarioDrogas;

    @Column(name = "status", length = 1)
    private String status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ACS getAcs() {
        return acs;
    }

    public void setAcs(ACS acs) {
        this.acs = acs;
    }

    public Funcionario getFuncionario() {
        return funcionarioResponsavel;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionarioResponsavel = funcionario;
    }

    public String getVulnerabilidadeSocial() {
        return vulnerabilidadeSocial;
    }

    public void setVulnerabilidadeSocial(String vulnerabilidadeSocial) {
        this.vulnerabilidadeSocial = vulnerabilidadeSocial;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public ACS getAcsResponsavel() {
        return acs;
    }

    public void setAcsResponsavel(ACS acsResponsavel) {
        this.acs = acsResponsavel;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getPuerpera() {
        return puerpera;
    }

    public void setPuerpera(String puerpera) {
        this.puerpera = puerpera;
    }

    public String getRecemNascido() {
        return recemNascido;
    }

    public void setRecemNascido(String recemNascido) {
        this.recemNascido = recemNascido;
    }

    public String getCrianca() {
        return crianca;
    }

    public void setCrianca(String crianca) {
        this.crianca = crianca;
    }

    public String getDesnutricao() {
        return desnutricao;
    }

    public void setDesnutricao(String desnutricao) {
        this.desnutricao = desnutricao;
    }

    public String getReabilitacaoDeficiencia() {
        return reabilitacaoDeficiencia;
    }

    public void setReabilitacaoDeficiencia(String reabilitacaoDeficiencia) {
        this.reabilitacaoDeficiencia = reabilitacaoDeficiencia;
    }

    public String getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(String hipertensao) {
        this.hipertensao = hipertensao;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getDpocEnfisema() {
        return dpocEnfisema;
    }

    public void setDpocEnfisema(String dpocEnfisema) {
        this.dpocEnfisema = dpocEnfisema;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getOutrasDoencasCronicas() {
        return outrasDoencasCronicas;
    }

    public void setOutrasDoencasCronicas(String outrasDoencasCronicas) {
        this.outrasDoencasCronicas = outrasDoencasCronicas;
    }

    public String getHanseniase() {
        return hanseniase;
    }

    public void setHanseniase(String hanseniase) {
        this.hanseniase = hanseniase;
    }

    public String getTuberculose() {
        return tuberculose;
    }

    public void setTuberculose(String tuberculose) {
        this.tuberculose = tuberculose;
    }

    public String getDomiciliadosAcamados() {
        return domiciliadosAcamados;
    }

    public void setDomiciliadosAcamados(String domiciliadosAcamados) {
        this.domiciliadosAcamados = domiciliadosAcamados;
    }

    public String getVunerabilidadeSocial() {
        return vulnerabilidadeSocial;
    }

    public void setVunerabilidadeSocial(String vulnerabilidadeSocial) {
        this.vulnerabilidadeSocial = vulnerabilidadeSocial;
    }

    public String getBolsaFamilia() {
        return bolsaFamilia;
    }

    public void setBolsaFamilia(String bolsaFamilia) {
        this.bolsaFamilia = bolsaFamilia;
    }

    public String getSaudeMental() {
        return saudeMental;
    }

    public void setSaudeMental(String saudeMental) {
        this.saudeMental = saudeMental;
    }

    public String getUsuarioAlcool() {
        return usuarioAlcool;
    }

    public void setUsuarioAlcool(String usuarioAlcool) {
        this.usuarioAlcool = usuarioAlcool;
    }

    public String getUsuarioDrogas() {
        return usuarioDrogas;
    }

    public void setUsuarioDrogas(String usuarioDrogas) {
        this.usuarioDrogas = usuarioDrogas;
    }

}
