package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.dao.AtendimentoImunizacaoDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.FuncionarioDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.PacienteDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.PessoaDao;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumDoseVacina;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstrategiaImunizacao;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.AtendimentoImunizacao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Fornecedor;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Funcionario;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Pessoa;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.UnidadeSaude;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacina;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inicio {

    public static void main(String[] args) throws Exception {

//        // nome, datanascimento, cpf
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jefferson");
        pessoa.setDataNascimento(Date.from(Instant.EPOCH));
        pessoa.setCpf("12342341690");
        PessoaDao dao = new PessoaDao();
//        dao.salvar(pessoa);
//        dao.remover(198L);

//        // numeroProntuario, dataCadastro, cartaoSUS, pessoa
        Paciente paciente = new Paciente();
        paciente.setCartaoSUS("123453049567451");
        paciente.setDataCadastro(Date.from(Instant.EPOCH));
        paciente.setNumeroProntuario(21);
        paciente.setPessoa(pessoa);
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.salvar(paciente);
//
//        // nome, cnpj
//        Fornecedor fornecedor = new Fornecedor();
//        fornecedor.setNome("Teste");
//        fornecedor.setCnpj("123456789098765");
//
//        // viaAdministracao, nome, dataFabricacao, dataValidade, fornecedor
//        Vacina vacina = new Vacina();
//        vacina.setViaAdministracao(EnumViaAdministracao.ORAL);
//        vacina.setNome("Teste");
//        vacina.setDataFabricacao(Date.from(Instant.EPOCH));
//        vacina.setDataValidade(Date.from(Instant.EPOCH));
//
//        List<Vacina> vacinas = new ArrayList<Vacina>();
//        vacinas.add(vacina);
//
//        fornecedor.setVacinas(vacinas);
//        
//        vacina.setFornecedor(fornecedor);
//
//        // cnes, nome, numero
//        UnidadeSaude unidadeSaude = new UnidadeSaude();
//        unidadeSaude.setCnes(3211);
//        unidadeSaude.setNome("Teste");
//        unidadeSaude.setNumero(1);
//
//        // matricula, codigoEquipeINE, pessoa, unidadeSaude, nomeUsuario, senha
//        Funcionario funcionario = new Funcionario();
//        funcionario.setMatricula(12);
//        funcionario.setCodigoEquipeINE("23ef");
//        funcionario.setPessoa(pessoa);
////        funcionario.setUnidadeSaude(unidadeSaude);
//        funcionario.setNomeUsuario("Teste");
//        funcionario.setSenha("teste");
//        
//        FuncionarioDao funcionarioDao = new FuncionarioDao();
//        funcionarioDao.remover(161L);
//
//        // registroCoren, funcionario
//        Vacinador vacinador = new Vacinador();
//        vacinador.setRegistroCoren(23131);
//        vacinador.setFuncionario(funcionario);
//
//        // vacinador, dataAtendimento, dose, vacina, estrategiaImunizacao, paciente
//        AtendimentoImunizacao atendimentoImunizacao = new AtendimentoImunizacao();
//        atendimentoImunizacao.setVacinador(vacinador);
//        atendimentoImunizacao.setDataAtendimento(Date.from(Instant.EPOCH));
//        atendimentoImunizacao.setDose(EnumDoseVacina.DOSE_UNICA);
//        atendimentoImunizacao.setVacina(vacina);
//        atendimentoImunizacao.setEstrategiaImunizacao(EnumEstrategiaImunizacao.ROTINA);
//        atendimentoImunizacao.setPaciente(paciente);
//
//        AtendimentoImunizacaoDao atendimentoImunizacaoDao = new AtendimentoImunizacaoDao();
//        atendimentoImunizacaoDao.salvar(atendimentoImunizacao);

    }
}
