package br.edu.ifpb.monteiro.ads.infosaude.beans;

import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEstados;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumEtnias;
import br.edu.ifpb.monteiro.ads.infosaude.enumerations.EnumGeneros;
import br.edu.ifpb.monteiro.ads.infosaude.modelo.Vacinador;
import br.edu.ifpb.monteiro.ads.infosaude.service.excecoes.ServiceExcecoes;
import br.edu.ifpb.monteiro.ads.infosaude.service.interfaces.VacinadorServiceIF;
import java.time.Instant;
import java.util.ArrayList;
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
 * @date 20/05/2015
 */
@Model
public class VacinadorBean {

    private String confirmarSenha;

    @Inject
    private Vacinador vacinador;

    private Long idAuxiliar;

    @Inject
    private VacinadorServiceIF serviceIF;
    private String mensangem;

    private List<Vacinador> vacinadoresFilter;

    @PostConstruct
    public void init() {

        vacinadoresFilter = new ArrayList<>();

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

    public String salvar() {
        try {

            serviceIF.salvar(vacinador);
            JsfUtil.addSuccessMessage("Usuário da UBS cadastrado com sucesso");

        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex.getMessage());

            return null;

        }
        return "";
    }

    public List<Vacinador> getVacinadores() {

        try {
            return serviceIF.buscarTudo();
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(VacinadorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public void preparaEdicao() {

        try {
            vacinador = serviceIF.consultarPorId(idAuxiliar);
        } catch (ServiceExcecoes ex) {
            Logger.getLogger(Vacinador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void mensagem() {
        if ("true".equals(mensangem)) {
            JsfUtil.addSuccessMessage("Usuário da UBS removido com sucesso");

        }
    }

    public List<Vacinador> getVacinadoresFilter() {
        return vacinadoresFilter;
    }

    public void setVacinadoresFilter(List<Vacinador> vacinadoresFilter) {
        this.vacinadoresFilter = vacinadoresFilter;
    }

    public Vacinador getVacinador() {
        return vacinador;
    }

    public void setVacinador(Vacinador vacinador) {
        this.vacinador = vacinador;
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

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public void setMensangem(String mensangem) {
        this.mensangem = mensangem;
    }

    public String getMensangem() {
        return mensangem;
    }

    public Long getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(Long idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

}
