
package br.edu.ifpb.monteiro.ads.infosaude.beans;

/**
 * @brief Classe teste
 * @author Jefferson Emanuel C. da Silva <jefferson.ecs@gmail.com>
 * @date   13/03/2015
 */


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
 
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import br.edu.ifpb.monteiro.ads.infosaude.beans.Theme;
import br.edu.ifpb.monteiro.ads.infosaude.beans.ThemeService;
 
@ManagedBean
public class teste {
     
    @ManagedProperty("#{themeService}")
    private ThemeService service;
     
    private DualListModel<String> cities;
    private DualListModel<Theme> themes;
     
    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
         
        citiesSource.add("Crianças menores de 5 anos");
        citiesSource.add("Gestantes");
        citiesSource.add("Diabéticos");
        citiesSource.add("Hipertenso");
         
        cities = new DualListModel<String>(citiesSource, citiesTarget);
         
        //Themes
        List<Theme> themesSource = service.getThemes().subList(0, 6);
        List<Theme> themesTarget = new ArrayList<Theme>();
         
        themes = new DualListModel<Theme>(themesSource, themesTarget);
         
    }
 
    public DualListModel<String> getCities() {
        return cities;
    }
 
    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }
 
    public ThemeService getService() {
        return service;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }
 
    public DualListModel<Theme> getThemes() {
        return themes;
    }
 
    public void setThemes(DualListModel<Theme> themes) {
        this.themes = themes;
    }
     
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Theme) item).getName()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
}