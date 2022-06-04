/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.EmpleadoFacadeLocal;
import EJB.RolFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Empleado;
import modelo.Rol;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class AltaEmpleadoController implements Serializable {
    private Empleado empleado;
    private List<Rol> roles;
    private String nombreRol;

    
    @EJB
    private RolFacadeLocal rolEJB; 
    
    @EJB
    private EmpleadoFacadeLocal empleadoEJB;
    
    @PostConstruct
    
    public void init(){
        empleado = new Empleado();
        roles = rolEJB.findAll();
    }  
    
    
    
    public void addEmpleado(){
      try{
            empleado.setRol(rolEJB.findNombre(nombreRol));
            empleadoEJB.create(empleado);
        }catch(Exception e){
            System.out.println("Error insertando empleado " + e.getMessage());

        }  
    }
    
       
    public List<String> roles(){
        ArrayList<String> nombre = new ArrayList<>();
        
        for(int i=0;i<this.roles.size();i++){
            nombre.add(roles.get(i).getNombreRol());
        }
        
        return nombre;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public RolFacadeLocal getRolEJB() {
        return rolEJB;
    }

    public void setRolEJB(RolFacadeLocal rolEJB) {
        this.rolEJB = rolEJB;
    }

    public EmpleadoFacadeLocal getEmpleadoEJB() {
        return empleadoEJB;
    }

    public void setEmpleadoEJB(EmpleadoFacadeLocal empleadoEJB) {
        this.empleadoEJB = empleadoEJB;
    }


    
    
}
