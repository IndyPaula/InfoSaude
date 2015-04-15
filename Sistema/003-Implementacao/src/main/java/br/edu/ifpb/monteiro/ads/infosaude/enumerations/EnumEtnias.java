package br.edu.ifpb.monteiro.ads.infosaude.enumerations;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 */
public enum EnumEtnias {
   
    AMARELO("Amarelo"),
    BRANCO("Branco"),
    PARDO("Pardo"),
    MULATO("Mulato"),
    INDIGENA("Indígena"),
    CABOCLO("Caboclo"),
    CAFUZO("Cafuzo"),
    NEGRO("Negro");
    
    private String descricao;

    EnumEtnias(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
