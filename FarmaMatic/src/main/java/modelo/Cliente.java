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
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column(name = "nombreCliente")
    private String nombreCliente;
    
    @JoinColumn(name = "idCopago")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Copago copago;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Copago getCopago() {
        return copago;
    }

    public void setCopago(Copago copago) {
        this.copago = copago;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idCliente;
        hash = 59 * hash + Objects.hashCode(this.nombreCliente);
        hash = 59 * hash + Objects.hashCode(this.copago);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.nombreCliente, other.nombreCliente)) {
            return false;
        }
        if (!Objects.equals(this.copago, other.copago)) {
            return false;
        }
        return true;
    }
    
    
    
}
