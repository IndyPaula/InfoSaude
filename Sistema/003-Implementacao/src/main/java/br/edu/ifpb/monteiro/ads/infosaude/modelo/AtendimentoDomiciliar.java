package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @date 15/04/2015
 */
@Entity(name = "atendimento_domiciliar")
@SequenceGenerator(name = "atendimento_domiciliar_seq", sequenceName = "atendimento_domiciliar_seq", initialValue = 1, allocationSize = 1)
public class AtendimentoDomiciliar implements Identificavel<AtendimentoDomiciliar>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "atendimento_domiciliar_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_atendimento", nullable = false)
    private Date dataAtendimento;

    @OneToOne
    private Paciente paciente;

    @Column(name = "motivo_visita", length = 45)
    private String motivoVisita;

    @Override
    public Long getId() {
        return id;
    }


}
