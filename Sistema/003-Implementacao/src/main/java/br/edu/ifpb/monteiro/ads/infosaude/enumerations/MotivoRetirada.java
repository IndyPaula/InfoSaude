package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 23/10/2015
 */
public enum MotivoRetirada implements Serializable {

    DETERIORADA("Deteriorada"),
    DANIFICADA("Danificada"),
    REMANEJADA("Remanejada"),
    ATENDIMENTO("Atendimento"),
    VENCIDA("Vencida");

    private String descricao;

    private MotivoRetirada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
