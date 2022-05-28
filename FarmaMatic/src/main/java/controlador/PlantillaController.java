package controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import modelo.Empleado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanch
 */
@Named
@SessionScoped
public class PlantillaController implements Serializable{
    
        private Empleado empleado;
        
        @PostConstruct
        public void init(){
            empleado = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("c");
        }
    
        
        public void verificarYMostrar() throws IOException{
       
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();

        if(!url.contains("index")&& !url.contains("principal") && !url.contains("dispensacion")){
            if((empleado == null) || !url.contains(empleado.getNombreUsuario().toLowerCase())){
                if(!url.contains("administrador")){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("noPermiso.xhtml");                }
            }
        }
    
    }
}