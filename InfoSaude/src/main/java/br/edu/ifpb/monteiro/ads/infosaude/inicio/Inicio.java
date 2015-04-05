package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.dao.PacienteDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import java.time.Instant;
import java.util.Date;

public class Inicio {

    public static void main(String[] args) throws Exception {

        PessoaDao pessosDao = new PessoaDao();
        // nome, datanascimento, cpf
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jefferson");
        pessoa.setDataNascimento(Date.from(Instant.EPOCH));
        pessoa.setCpf("12345674910");

        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("123123456389456");
        paciente.setPacienteDataCadastro(Date.from(Instant.EPOCH));
        paciente.setPacienteNumeroProntuario(32);
        paciente.setPessoa(pessoa);

        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.salvar(paciente);
    }
}
