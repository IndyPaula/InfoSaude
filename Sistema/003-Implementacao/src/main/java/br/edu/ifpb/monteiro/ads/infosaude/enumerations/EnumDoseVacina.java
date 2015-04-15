/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumDoseVacina {
    
    
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
