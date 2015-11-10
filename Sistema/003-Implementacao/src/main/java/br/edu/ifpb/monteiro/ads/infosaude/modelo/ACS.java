package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 06/04/2015
 */
@Entity(name = "acs")
public class ACS extends Funcionario implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Column(name = "numero_area", length = 15, nullable = false)
    private Integer numeroArea;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "acs")
    @JoinColumn(name = "atendimento_domiciliar_id")
    private List<AtendimentoDomiciliar> atendimentos;
       
    public Integer getNumeroArea() {
        return numeroArea;
    }

    public void setNumeroArea(Integer numeroArea) {
        this.numeroArea = numeroArea;
    }

    public List<AtendimentoDomiciliar> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<AtendimentoDomiciliar> atendimentos) {
        this.atendimentos = atendimentos;
    }

}
