/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sanch
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;
    
    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;
    
    @Column(name = "usuario")
    private String nombreUsuario;
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @Column(name = "telefono")
    private int telefono;
    
    @JoinColumn(name = "idRol")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Rol rol;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idEmpleado;
        hash = 71 * hash + Objects.hashCode(this.nombreEmpleado);
        hash = 71 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 71 * hash + Objects.hashCode(this.contrasenia);
        hash = 71 * hash + this.telefono;
        hash = 71 * hash + Objects.hashCode(this.rol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombreEmpleado, other.nombreEmpleado)) {
            return false;
        }
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        return true;
    }
    
    
}
