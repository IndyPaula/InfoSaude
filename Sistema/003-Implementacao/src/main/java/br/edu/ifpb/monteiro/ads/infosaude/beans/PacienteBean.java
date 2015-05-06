package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.PacienteService;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PacienteServiceIF;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
@ManagedBean
@RequestScoped
public class PacienteBean {
    
    private PacienteServiceIF pacienteService;
    
    private Paciente paciente;
    
    public PacienteBean() {
        paciente = new Paciente();
        
        paciente.setDataCadastro(getDataAtual());
        
        pacienteService = new PacienteService();
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
    
    public String salvar() {
        try {
            pacienteService.salvar(paciente);
            JsfUtil.addSuccessMessage("Usuário da UBS cadastrado com sucesso");
            paciente = new Paciente();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(AdministradorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
