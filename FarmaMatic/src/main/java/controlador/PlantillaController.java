package controlador;

import java.io.IOException;
import java.io.Serializable;
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
        public void verificarYMostrar() throws IOException{
        Empleado devuelve = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        
        if(!url.contains("index")&& !url.contains("principal") && !url.contains("dispensacion")){
            if((devuelve == null) || !url.contains(devuelve.getNombreUsuario().toLowerCase())){
                if(!url.contains("administrador")){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("noPermiso.xhtml");                }
            }
        }
    
    }
}
