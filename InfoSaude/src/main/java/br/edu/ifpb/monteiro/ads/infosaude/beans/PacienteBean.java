package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.modelo.Paciente;
import br.edu.ifpb.monteiro.ads.infosaude.service.PacienteService;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.PacienteServiceIF;
import javax.inject.Named;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 14/04/2015
 */
@Named
public class PacienteBean {

    private PacienteServiceIF pacienteService;

    private Paciente paciente;

    public PacienteBean() {
        pacienteService = new PacienteService();
    }

    public PacienteServiceIF getPacienteService() {
        return pacienteService;
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

}
