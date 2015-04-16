package br.edu.ifpb.monteiro.ads.infosaude.inicio;

import br.edu.ifpb.monteiro.ads.infosaude.dao.AtendimentoImunizacaoDao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.PacienteDao;
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
import br.edu.ifpb.monteiro.ads.infosaude.service.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PessoaServiceIF;
import java.time.Instant;
import java.util.Date;


public class Inicio {

    public static void main(String[] args) throws Exception {

        
////        // nome, datanascimento, cpf
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jefferson");
        pessoa.setDataNascimento(Date.from(Instant.EPOCH));
        pessoa.setCpf("12332341690");
//        PessoaDao pd = new PessoaDao();
//        pd.buscarPorCampo("cpf", "12342341690");
//        PessoaService pessoaService = new PessoaService();
//        pessoaService.salvar(pessoa);

         Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Jefferson");
        pessoa2.setDataNascimento(Date.from(Instant.EPOCH));
        pessoa2.setCpf("12332341689");
        
        
//        // numeroProntuario, dataCadastro, cartaoSUS, pessoa
        Paciente paciente = new Paciente();;
        paciente.setCartaoSUS("123453049567451");
        paciente.setDataCadastro(Date.from(Instant.EPOCH));
        paciente.setNumeroProntuario(21);
        paciente.setPessoa(pessoa);
        PacienteDao pacienteDao = new PacienteDao();
        pacienteDao.salvar(paciente);
//
//        // nome, cnpj
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Teste");
        fornecedor.setCnpj("123456789098765");
//
//        // viaAdministracao, nome, dataFabricacao, dataValidade, fornecedor, numeroLote
        Vacina vacina = new Vacina();
        vacina.setViaAdministracao(EnumViaAdministracao.ORAL);
        vacina.setNome("Teste");
        vacina.setDataFabricacao(Date.from(Instant.EPOCH));
        vacina.setDataValidade(Date.from(Instant.EPOCH));
        vacina.setFornecedor(fornecedor);
        vacina.setNumeroLote("123");
//
//        // cnes, nome, numero
        UnidadeSaude unidadeSaude = new UnidadeSaude();
        unidadeSaude.setCnes(3211);
        unidadeSaude.setNome("Teste");
        unidadeSaude.setNumero(1);
//
//        // matricula, codigoEquipeINE, pessoa, unidadeSaude, nomeUsuario, senha
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(12);
        funcionario.setCodigoEquipeINE("23ef");
        funcionario.setPessoa(pessoa2);
//        funcionario.setUnidadeSaude(unidadeSaude);
        funcionario.setNomeUsuario("Teste");
        funcionario.setSenha("teste");
//        
//        FuncionarioDao funcionarioDao = new FuncionarioDao();
//        funcionarioDao.remover(161L);
//
//        // registroCoren, funcionario
        Vacinador vacinador = new Vacinador();
        vacinador.setRegistroCoren(23131);
        vacinador.setFuncionario(funcionario);
//
//        // vacinador, dataAtendimento, dose, vacina, estrategiaImunizacao, paciente
        AtendimentoImunizacao atendimentoImunizacao = new AtendimentoImunizacao();
        atendimentoImunizacao.setVacinador(vacinador);
        atendimentoImunizacao.setDataAtendimento(Date.from(Instant.EPOCH));
        atendimentoImunizacao.setDose(EnumDoseVacina.DOSE_UNICA);
        atendimentoImunizacao.setVacina(vacina);
        atendimentoImunizacao.setEstrategiaImunizacao(EnumEstrategiaImunizacao.ROTINA);
        atendimentoImunizacao.setPaciente(paciente);
//
        AtendimentoImunizacaoDao atendimentoImunizacaoDao = new AtendimentoImunizacaoDao();
        atendimentoImunizacaoDao.salvar(atendimentoImunizacao);

    }
}
