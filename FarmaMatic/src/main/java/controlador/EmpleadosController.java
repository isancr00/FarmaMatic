/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EmpleadoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
public class EmpleadosController implements Serializable{
    
     private List<Empleado> empleados;
     
     @EJB
     private EmpleadoFacadeLocal empleadoEJB;
     
     @PostConstruct
     public void init(){
         empleados = empleadoEJB.findAll();
     }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public EmpleadoFacadeLocal getEmpleadoEJB() {
        return empleadoEJB;
    }

    public void setEmpleadoEJB(EmpleadoFacadeLocal empleadoEJB) {
        this.empleadoEJB = empleadoEJB;
    }
     
    public void eliminarEmpleado(Empleado empleado) throws IOException{
        empleadoEJB.remove(empleado);
        
        String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/FarmaMatic/faces/privado/administrador/empleados.xhtml;jsessionid="+sessionId); 

    }
    
     public String add(){
        return "addEmpleado.xhtml";
    }
     
    
}
