package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumEstrategiaImunizacao {
 
    
    ROTINA("Rotina"),
    ESPECIAL("Especial"),
    BLOQUEIO("Bloqueio"),
    INTENSIFICACAO("Intensificação"), 
    CAMPANHA_INDISCRIMINADA("Campanha Indiscriminada"),
    CAMPANHA_SELETIVA("Campanha Seletiva"),
    SOROTERAPIA("Soroterapia");
    
    private String descricao;

    private EnumEstrategiaImunizacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
