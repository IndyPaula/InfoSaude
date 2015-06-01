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
    private Long idAuxiliar;
    private String mensangem;

    private List<Paciente> pacientesFilter;

    public PacienteBean() {

    }

    @PostConstruct
    public void init() {

        pacientesFilter = new ArrayList<>();

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

    public Long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public String getMensangem() {
        return mensangem;
    }

    public void setMensangem(String mensangem) {
        this.mensangem = mensangem;
    }

    public List<Paciente> getPacientesFilter() {
        return pacientesFilter;
    }

    public void setPacientesFilter(List<Paciente> pacientesFilter) {
        this.pacientesFilter = pacientesFilter;
    }

    public void mensagem() {
        if ("true".equals(mensangem)) {
            JsfUtil.addSuccessMessage("Usuário da UBS removido com sucesso");

        }
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

    public void preparaEdicao() {

        try {
            System.out.println(idAuxiliar);
            paciente = pacienteService.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String remover(Paciente p) {

        if (p != null) {

            try {
                pacienteService.remover(p);

                Thread.sleep(1000);

                JsfUtil.redirect("/InfoSaude/resources/paginas/paciente/buscar_usuario_ubs.xhtml?faces-redirect=true");
                return "buscar_usuarios_ubs.xhtml";

            } catch (ServiceExcecoes ex) {
                Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Erro ao tentar remover paciente");
            } catch (InterruptedException ex) {
                Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JsfUtil.addErrorMessage("Erro ao tentar remover Usuário da UBS");
        }
        return null;
    }

    public String update() throws BeanExcecao {

        try {
            pacienteService.cpfExiste(idAuxiliar, paciente.getCpf());
            paciente.setId(idAuxiliar);
            pacienteService.atualizar(paciente);
            JsfUtil.addSuccessMessage("Informações atualizadas com sucesso");
            return "editar_usuario_ubs.xhtml?id=" + paciente.getId();

        } catch (ServiceExcecoes | DaoExcecoes ex) {

            JsfUtil.addErrorMessage(ex.getMessage());
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
