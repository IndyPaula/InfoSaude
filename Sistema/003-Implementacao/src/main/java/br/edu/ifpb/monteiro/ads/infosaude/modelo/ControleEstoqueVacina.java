package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.MotivoRetirada;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 22/10/2015
 */
@Entity(name = "controle_estoque_vacina")
@SequenceGenerator(name = "controle_estoque_vacina_seq", allocationSize = 1, initialValue = 1, sequenceName = "controle_estoque_vacina_seq")
public class ControleEstoqueVacina implements Identificavel<ControleEstoqueVacina>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "controle_estoque_vacina_seq")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_retirada", nullable = false)
    private Date dataRetirada;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_retirada", nullable = false, length = 45)
    private MotivoRetirada motivoRetirada;

    @ManyToOne
    private Vacina vacina;

    @Column(name = "quantidade_doses")
    private Integer quantidadeDoses;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public MotivoRetirada getMotivoRetirada() {
        return motivoRetirada;
    }

    public void setMotivoRetirada(MotivoRetirada motivoRetirada) {
        this.motivoRetirada = motivoRetirada;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Integer getQuantidadeDoses() {
        return quantidadeDoses;
    }

    public void setQuantidadeDoses(Integer quantidadeDoses) {
        this.quantidadeDoses = quantidadeDoses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ControleEstoqueVacina other = (ControleEstoqueVacina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
