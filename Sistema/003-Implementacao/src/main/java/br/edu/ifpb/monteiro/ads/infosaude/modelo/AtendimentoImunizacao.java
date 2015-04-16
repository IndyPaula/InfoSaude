package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumDoseVacina;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstrategiaImunizacao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "atendimento_imunizacao")
@SequenceGenerator(name = "atendimento_imunizacao_seq", sequenceName = "atendimento_imunizacao_seq", initialValue = 1, allocationSize = 1)
public class AtendimentoImunizacao implements Identificavel<AtendimentoImunizacao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "atendimento_imunizacao_seq")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Vacinador vacinador;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_atendimento", nullable = false)
    private Date dataAtendimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_agendamento", nullable = true)
    private Date dataAgendamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "dose", nullable = false, length = 20)
    private EnumDoseVacina dose;

    @OneToOne(cascade = CascadeType.ALL)
    private Vacina vacina;

    @Enumerated(EnumType.STRING)
    @Column(name = "estrategia_imunizacao", length = 25, nullable = false)
    private EnumEstrategiaImunizacao estrategiaImunizacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;

    @Override
    public Long getId() {
        return id;
    }

    public Vacinador getVacinador() {
        return vacinador;
    }

    public void setVacinador(Vacinador vacinador) {
        this.vacinador = vacinador;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public EnumDoseVacina getDose() {
        return dose;
    }

    public void setDose(EnumDoseVacina dose) {
        this.dose = dose;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public EnumEstrategiaImunizacao getEstrategiaImunizacao() {
        return estrategiaImunizacao;
    }

    public void setEstrategiaImunizacao(EnumEstrategiaImunizacao estrategiaImunizacao) {
        this.estrategiaImunizacao = estrategiaImunizacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final AtendimentoImunizacao other = (AtendimentoImunizacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
