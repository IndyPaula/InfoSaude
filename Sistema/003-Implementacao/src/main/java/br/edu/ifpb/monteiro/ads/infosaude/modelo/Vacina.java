package br.edu.ifpb.monteiro.ads.infosaude.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumViaAdministracao;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.interfaces.Identificavel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 07/04/2015
 */
@Entity(name = "vacina")
@SequenceGenerator(name = "vacina_seq", sequenceName = "vacina_seq", initialValue = 1, allocationSize = 1)
public class Vacina implements Identificavel<Vacina>, Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vacina_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "via_administracao", nullable = true, length = 25)
    private EnumViaAdministracao viaAdministracao;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "instrucao_administracao", length = 255)
    private String instrucaoAdministracao;

    @Column(name = "instrucao_armazenamento", length = 255)
    private String instrucaoArmazenamento;

    @Column(name = "contra_indicacoes", length = 255)
    private String contraIndicacoes;

    @Column(name = "reacoes_adversas", length = 255)
    private String reacoesAdversas;

    @Column(name = "quantidade_doses_recebidas", nullable = false)
    private Integer quantidadeDosesRecebidas;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fabricacao", nullable = false)
    private Date dataFabricacao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "lote", nullable = false, length = 20)
    private String lote;

    @Column(name = "laboratorio", nullable = false, length = 45)
    private String laboratorio;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "quantidade_doses_inutilizadas")
    private Integer quantidadeDosesInutilizadas;

    @Column(name = "quantidade_doses_remanejadas")
    private Integer quantidadeDosesRemanejadas;

    @Column(name = "quantidade_doses_solicitadas")
    private Integer quantidadeDosesSolicitadas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacina")
    @JoinColumn(name = "atendimento_imunizacao_id")
    private List<AtendimentoImunizacao> imunizacoes;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public EnumViaAdministracao getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(EnumViaAdministracao viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrucaoAdministracao() {
        return instrucaoAdministracao;
    }

    public void setInstrucaoAdministracao(String instrucaoAdministracao) {
        this.instrucaoAdministracao = instrucaoAdministracao;
    }

    public String getInstrucaoArmazenamento() {
        return instrucaoArmazenamento;
    }

    public void setInstrucaoArmazenamento(String instrucaoArmazenamento) {
        this.instrucaoArmazenamento = instrucaoArmazenamento;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getReacoesAdversas() {
        return reacoesAdversas;
    }

    public void setReacoesAdversas(String reacoesAdversas) {
        this.reacoesAdversas = reacoesAdversas;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getQuantidadeDosesRecebidas() {
        return quantidadeDosesRecebidas;
    }

    public void setQuantidadeDosesRecebidas(Integer quantidadeDosesRecebidas) {
        this.quantidadeDosesRecebidas = quantidadeDosesRecebidas;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<AtendimentoImunizacao> getImunizacoes() {
        return imunizacoes;
    }

    public void setImunizacoes(List<AtendimentoImunizacao> imunizacoes) {
        this.imunizacoes = imunizacoes;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getQuantidadeDosesInutilizadas() {
        return quantidadeDosesInutilizadas;
    }

    public void setQuantidadeDosesInutilizadas(Integer quantidadeDosesInutilizadas) {
        this.quantidadeDosesInutilizadas = quantidadeDosesInutilizadas;
    }

    public Integer getQuantidadeDosesRemanejadas() {
        return quantidadeDosesRemanejadas;
    }

    public void setQuantidadeDosesRemanejadas(Integer quantidadeDosesRemanejadas) {
        this.quantidadeDosesRemanejadas = quantidadeDosesRemanejadas;
    }

    public Integer getQuantidadeDosesSolicitadas() {
        return quantidadeDosesSolicitadas;
    }

    public void setQuantidadeDosesSolicitadas(Integer quantidadeDosesSolicitadas) {
        this.quantidadeDosesSolicitadas = quantidadeDosesSolicitadas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((id == null) ? 0 : id.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacina other = (Vacina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}