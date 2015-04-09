package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Inicio {
    
    public static void main(String[] args) {
        
        PessoaDao dao = new PessoaDao();
        Pessoa p = new Pessoa();
        p.setNome("fgdfggdgdgd");
        p.setDataNascimento(new Date(1991, 04, 10));
       
        try {
            dao.salvar(p);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
