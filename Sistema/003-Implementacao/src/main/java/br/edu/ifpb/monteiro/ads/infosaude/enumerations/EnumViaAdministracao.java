package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumViaAdministracao {
    
    INTRAMUSCULAR("Intramúscular"),
    ORAL("Oral"),
    SUBCUTANEA("Subcutanea"),
    INTRADERMICA("Intradérmica");


    private String descricao;

    private EnumViaAdministracao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
