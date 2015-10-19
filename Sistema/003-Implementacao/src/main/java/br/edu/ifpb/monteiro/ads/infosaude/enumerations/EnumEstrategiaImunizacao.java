package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

import java.io.Serializable;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumEstrategiaImunizacao implements Serializable{
 
    
    ROTINA("Rotina"),
    ESPECIAL("Especial"),
    BLOQUEIO("Bloqueio"),
    INTENSIFICACAO("Intensificação"), 
    CAMPANHA_INDISCRIMINADA("Campanha Indiscriminada"),
    CAMPANHA_SELETIVA("Campanha Seletiva"),
    CAMPANHA_SEGUIMENTO("Campanha de Saguimento"),
    SOROTERAPIA("Soroterapia");
    
    private String descricao;

    private EnumEstrategiaImunizacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
