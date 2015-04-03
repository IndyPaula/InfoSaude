package br.edu.ifpb.monteiro.ads.infosaude.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import org.primefaces.event.TabChangeEvent;

/**
 * @brief Classe ControlarTab
 * @author Jefferson Emanuel C. da Silva <jefferson.ecs@gmail.com>
 * @date 17/03/2015
 */
@ManagedBean(name = "tab")
public class ControlarTab {
    
    
    
    String tabAtual;

    public void onTabChange(TabChangeEvent event) {

        String activeTab = event.getTab().getId();

        int activeTabIndex = 0;

        //Realiza um loop para identificar qual é a tab que foi selecionada.  
        //Obs.: As tabs filhas devem ter um id definido, para que seja facilitada a busca  
        //e o entendimento pois o JSF por padrão coloca IDs com nomes que ele mesmo escolhe   
        //para as tabs.  
        for (UIComponent comp : event.getTab().getParent().getChildren()) {
            if (comp.getId().equals(activeTab)) {
                break;
            }
            activeTabIndex++;
        }

        System.out.println("ID da Tab Atual: " + event.getTab().getId());
        System.out.println("Index da Tab Atual: " + activeTabIndex);

//        setTabAtual(activeTabIndex);
    }
    

}
