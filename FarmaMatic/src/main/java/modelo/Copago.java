/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sanch
 */
@Entity
@Table(name = "copagos")
public class Copago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCopago;
    
    @Column(name = "porcentaje")
    private int porcentaje;

    public int getIdCopago() {
        return idCopago;
    }

    public void setIdCopago(int idCopago) {
        this.idCopago = idCopago;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idCopago;
        hash = 97 * hash + this.porcentaje;
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
        final Copago other = (Copago) obj;
        if (this.idCopago != other.idCopago) {
            return false;
        }
        if (this.porcentaje != other.porcentaje) {
            return false;
        }
        return true;
    }
    
    
}
