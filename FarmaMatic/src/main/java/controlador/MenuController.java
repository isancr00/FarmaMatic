/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.MenuFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Empleado;
import modelo.Menu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author sanch
 */
@ManagedBean
@Named
@SessionScoped
public class MenuController implements Serializable{
    private MenuModel modelo;
    
    @EJB
    private MenuFacadeLocal menuEJB;
    
    @PostConstruct
    public void init(){
        modelo = new DefaultMenuModel();
        obtenerMenu();
    }
    
    public void obtenerMenu(){
        
        Empleado devuelve = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("c"); 
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("c",devuelve);
        String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
        
        
        if(devuelve != null){
            List<Menu> menus = menuEJB.obtenerMenusUsuario(devuelve);
            String url = "//localhost:8080/FarmaMatic/faces/privado/principal.xhtml;jsessionid="+sessionId;
            DefaultMenuItem inicio = DefaultMenuItem.builder().value("Inicio").url(url).build();
            inicio.setUrl(url);
            modelo.getElements().add(inicio);     
                
            for(int i = 0;i<menus.size();i++){
                
                Menu menu = menus.get(i);
                String url2 = "//localhost:8080/FarmaMatic/faces" + menu.getUrl()+";jsessionid=" + sessionId;
         
                DefaultMenuItem item = DefaultMenuItem.builder().value(menu.getNombre()).url(url2).build();
                item.setUrl(url2);
                modelo.getElements().add(item);     
            }
        }
                
    }
    
     public String destruirSesion(){  
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "/index.xhtml?faces-redirect=true";
    }


    public MenuModel getModelo() {
        return modelo;
    }

    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

    public MenuFacadeLocal getMenuEJB() {
        return menuEJB;
    }

    public void setMenuEJB(MenuFacadeLocal menuEJB) {
        this.menuEJB = menuEJB;
    }
}
