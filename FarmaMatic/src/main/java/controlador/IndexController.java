/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EmpleadoFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Empleado;

/**
 *
 * @author sanch
 */

@Named
@SessionScoped
public class IndexController implements Serializable {
    private Empleado empleado;
    
    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    
    
    @PostConstruct
    public void init(){
        empleado = new Empleado();
    }
    
    
    public String verificarUsuario(){
        
        Empleado empleadoB = null;
        
        empleadoB =  empleadoEJB.verificarEmpleado(this.empleado);
        if(empleadoB == null){
            System.out.println("Insuficiente");
            return "noPermiso.xhtml";
        }else{
            System.out.println("Suficiente");  
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", empleadoB);
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
