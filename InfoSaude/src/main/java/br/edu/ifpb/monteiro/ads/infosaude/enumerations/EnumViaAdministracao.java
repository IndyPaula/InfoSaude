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
public enum EnumViaAdministracao {
    
    INTRAMUSCULAR("Intramuscular"),
    ORAL("Oral"),
    SUBCUTANEA("Subcutanea"),
    INTRADERMICA("Intradermica");


    private String descricao;

    private EnumViaAdministracao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
