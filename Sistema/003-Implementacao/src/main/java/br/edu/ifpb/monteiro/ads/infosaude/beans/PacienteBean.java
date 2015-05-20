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
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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

    public PacienteBean() {

    }

    @PostConstruct
    public void init() {

        paciente.setDataCadastro(getDataAtual());

    }

    public Date getDataAtual() {
        Calendar calendar
                = new Calendar.Builder()
                .setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"))
                .setLocale(new Locale("pt", "br"))
                .setInstant(new Date())
                .build();
        Instant instantAPartirDoCalendar = calendar.toInstant();
        Date hoje = Date.from(instantAPartirDoCalendar);
        return hoje;
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

    public String salvar() {
        try {

            pacienteService.cpfExiste(null, paciente.getCpf());

            pacienteService.salvar(paciente);
            JsfUtil.addSuccessMessage("Usuário da UBS cadastrado com sucesso");

        } catch (ServiceExcecoes | DaoExcecoes ex) {
            
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
            paciente = pacienteService.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String remover(Paciente p) throws BeanExcecao {

        if (p != null) {

            try {
                pacienteService.remover(p);
                JsfUtil.addSuccessMessage("Paciente removido com sucesso");
                
                Thread.sleep(1000);
                
                JsfUtil.redirect("/InfoSaude/resources/paginas/paciente/buscar_usuario_ubs.xhtml?faces-redirect=true");
                return "buscar_usuarios_ubs.xhtml";

            } catch (ServiceExcecoes ex) {

                JsfUtil.addErrorMessage("Erro ao tentar remover paciente");
            } catch (InterruptedException ex) {
                Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JsfUtil.addErrorMessage("Erro ao tentar remover paciente");
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

        }
        return null;
    }

}
