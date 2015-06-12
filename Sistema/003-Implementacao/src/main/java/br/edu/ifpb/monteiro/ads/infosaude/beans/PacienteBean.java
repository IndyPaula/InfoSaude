package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.beans.excecaoes.BeanExcecao;
import br.edu.ifpb.monteiro.ads.infosaude.dao.excecoes.DaoExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PacienteServiceIF;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
@Model
public class PacienteBean {

    @Inject
    private PacienteServiceIF pacienteService;
    private List<Paciente> pacientes;
    @Inject
    private Paciente paciente;
    private Paciente pacienteSelected;

    private List<Paciente> pacientesFilter;

    public PacienteBean() {

    }

    @PostConstruct
    public void init() {

        pacientesFilter = new ArrayList<>();

    }

    public String salvar() {
        try {

            pacienteService.cpfExiste(null, paciente.getCpf());

            pacienteService.salvar(paciente);
            JsfUtil.addSuccessMessage("Usuário da UBS cadastrado com sucesso");

        } catch (ServiceExcecoes | DaoExcecoes ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

            return null;

        }
        return "buscar_usuario_ubs.xhtml";
    }

    public List<Paciente> getPacientes() {

        try {

            pacientes = pacienteService.buscarTudo();

            return pacientes;
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void remover() {

        try {
            pacienteService.remover(pacienteSelected);
            JsfUtil.addSuccessMessage("Usuário da UBS removido com sucesso");

        } catch (ServiceExcecoes ex) {
            JsfUtil.addErrorMessage("Erro ao tentar remover Usuário da UBS");
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String update() throws BeanExcecao {

        try {
            Long id = pacienteService.buscarPorCampo("cpf", paciente.getCpf()).getId();

            pacienteService.cpfExiste(id, paciente.getCpf());
            paciente.setId(id);
            pacienteService.atualizar(paciente);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "buscar_usuario_ubs.xhtml";

        } catch (ServiceExcecoes | DaoExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String selecinaExcluir() {

        if (pacienteSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");

        } else {
            remover();
        }
        return "buscar_usuario_ubs.xhtml";
    }

    public String selecinaEditar() {

        if (pacienteSelected == null) {
            JsfUtil.addErrorMessage("Selecione um item da tabela");
            return null;
        } else {
            return "editar_usuario_ubs.xhtml";
        }

    }

    public Date getDataAtual() {

        return new Date();
    }

    public PacienteServiceIF getPacienteService() {
        return pacienteService;
    }

    public EnumEstados[] getEstado() {
        return EnumEstados.values();
    }

    public EnumGeneros[] getSexo() {
        return EnumGeneros.values();
    }

    public EnumEtnias[] getEtnias() {
        return EnumEtnias.values();
    }

    public void setPacienteService(PacienteServiceIF pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Paciente getPaciente() {

        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPacienteSelected() {
        return pacienteSelected;
    }

    public void setPacienteSelected(Paciente pacienteSelected) {
        this.pacienteSelected = pacienteSelected;
    }

    public List<Paciente> getPacientesFilter() {
        return pacientesFilter;
    }

    public void setPacientesFilter(List<Paciente> pacientesFilter) {
        this.pacientesFilter = pacientesFilter;
    }

}
