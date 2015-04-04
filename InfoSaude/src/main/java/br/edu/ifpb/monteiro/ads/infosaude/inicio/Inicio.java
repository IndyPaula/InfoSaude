
package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.Dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;


public class Inicio {
  
    
    
    public static void main(String[] args) {
        
        PessoaDao dao = new PessoaDao();
        Pessoa p = new Pessoa();
        p = dao.consultarPorId(Pessoa.class, 2L);
        System.out.println(p.getId());
    }
}
