/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EmpleadoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Empleado;

/**
 *
 * @author sanch
 */

@Named
@ViewScoped
public class IndexController implements Serializable {
    private Empleado empleado;
    
    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    
    
    @PostConstruct
    public void init(){
        empleado = new Empleado();
    }
    
    
    public String verificarUsuario() throws IOException{
        Empleado empleadoB = new Empleado();
        
         empleadoB =  empleadoEJB.verificarEmpleado(this.empleado);
        if(empleadoB == null){

            return "noPermiso.xhtml";
        }else{
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("c", empleadoB);
            Map<String,Object> mapa = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


            return "privado/principal.xhtml";
        }
    }
    
    
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
}
