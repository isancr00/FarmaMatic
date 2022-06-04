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
@Table(name = "ventas")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    
    @Column(name = "fechaVenta")
    private Date fechaVenta;
    
    @JoinColumn(name = "idEmpleado")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Empleado empleado;
    
    @JoinColumn(name = "idCliente")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @JoinColumn(name = "idDetalleVenta")
    @OneToOne(cascade = CascadeType.PERSIST)
    private DetalleDeVenta detVenta;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleDeVenta getDetVenta() {
        return detVenta;
    }

    public void setDetVenta(DetalleDeVenta detVenta) {
        this.detVenta = detVenta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idVenta;
        hash = 89 * hash + Objects.hashCode(this.fechaVenta);
        hash = 89 * hash + Objects.hashCode(this.empleado);
        hash = 89 * hash + Objects.hashCode(this.cliente);
        hash = 89 * hash + Objects.hashCode(this.detVenta);
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
        final Venta other = (Venta) obj;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (!Objects.equals(this.fechaVenta, other.fechaVenta)) {
            return false;
        }
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.detVenta, other.detVenta)) {
            return false;
        }
        return true;
    }
    
   
    
}
