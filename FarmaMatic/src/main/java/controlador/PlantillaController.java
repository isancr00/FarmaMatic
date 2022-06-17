package controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
@ViewScoped
public class PlantillaController implements Serializable{
            
        public void verificarYMostrar() throws IOException{
        Empleado empleado = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("c");
            
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        
        if(empleado!=null){
            if(!url.contains("Venta") && !url.contains("principal") && !url.contains("index") && !url.contains("dispensacion") && !url.contains("liente") && !url.contains("rod")){
                if(!url.contains(empleado.getRol().getNombreRol().toLowerCase())){
                    if(!url.contains("administrador")){
                       
                            FacesContext.getCurrentInstance().getExternalContext().redirect("//localhost:8080/FarmaMatic/noPermiso.xhtml"); 
                    }
                }
            }
           
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("//localhost:8080/FarmaMatic/errorLogin.xhtml");
        }
/*
        if(!url.contains("index")&& !url.contains("principal") && !url.contains("dispensacion")){
            if(!url.equals("http://localhost:8080/FarmaMatic/faces/privado/productos.xhtml")){
                if((empleado == null) || !url.contains(empleado.getRol().getNombreRol().toLowerCase())){
                    if(!url.contains("administrador")){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("//localhost:8080/FarmaMatic/noPermiso.xhtml");                
                    }
                }
            }else if((empleado == null) || !url.contains(empleado.getRol().getNombreRol().toLowerCase())){
                if(!url.contains("administrador")){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("//localhost:8080/FarmaMatic/noPermiso.xhtml");                
                }
            }
            
        }
    */
    }
}