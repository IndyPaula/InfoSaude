package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumDoseVacina implements Serializable{
    
    
    DOSE_UNICA("Dose Unica"),
    PRIMEIRA_DOSE("Primeira Dose"),
    SEGUNDA_DOSE("Segunda Dose"),
    TERCEIRA_DOSE("Terceira Dose"),
    QUARTA_DOSE("Quarta Dose"),
    REFORCO("Reforço"),
    SEGUNDO_REFORCO("Segundo Reforço"),
    TERCEIRO_REFORCO("Terceiro Reforço");
    
    private String descricao;
    
    
    EnumDoseVacina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
