/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sanch
 */
@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @GeneratedValue
    private int idRol;
    
    @Column(name = "nombreRol")
    private String nombreRol;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idRol;
        hash = 89 * hash + Objects.hashCode(this.nombreRol);
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
        final Rol other = (Rol) obj;
        if (this.idRol != other.idRol) {
            return false;
        }
        if (!Objects.equals(this.nombreRol, other.nombreRol)) {
            return false;
        }
        return true;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
       
}
