
package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.Dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Inicio {
  
    
    
    public static void main(String[] args) {
        
        PessoaDao dao = new PessoaDao();
        Pessoa p = new Pessoa();
        p.setIdPessoa(Long.MIN_VALUE);
        p.setNome("fgdfggdgdgd");
        p.setDataNascimento(Date.from(Instant.EPOCH));
        p.setCartaoSUS("1231312466778534");
        p.setCpf("42345677545");
        dao.salvar(p);
    }
}
