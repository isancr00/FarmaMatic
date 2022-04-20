/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "compras")
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;
    
    @Column(name = "fechaCompra")
    private Date fechaCompra;
    
    @JoinColumn(name = "idEmpleado")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Empleado empleado;
    
    @JoinColumn(name = "idProoveedor")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Prooveedor prooveedor;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Prooveedor getProoveedor() {
        return prooveedor;
    }

    public void setProoveedor(Prooveedor prooveedor) {
        this.prooveedor = prooveedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idCompra;
        hash = 71 * hash + Objects.hashCode(this.fechaCompra);
        hash = 71 * hash + Objects.hashCode(this.empleado);
        hash = 71 * hash + Objects.hashCode(this.prooveedor);
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
        final Compra other = (Compra) obj;
        if (this.idCompra != other.idCompra) {
            return false;
        }
        if (!Objects.equals(this.fechaCompra, other.fechaCompra)) {
            return false;
        }
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        if (!Objects.equals(this.prooveedor, other.prooveedor)) {
            return false;
        }
        return true;
    }
    
}
