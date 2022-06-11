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
    
    @Column(name = "importe")
    private float importe;
    
    @JoinColumn(name = "idEmpleado")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Empleado empleado;
    
    @JoinColumn(name = "idCliente")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Cliente cliente;

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

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idVenta;
        hash = 97 * hash + Objects.hashCode(this.fechaVenta);
        hash = 97 * hash + Float.floatToIntBits(this.importe);
        hash = 97 * hash + Objects.hashCode(this.empleado);
        hash = 97 * hash + Objects.hashCode(this.cliente);
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
        if (Float.floatToIntBits(this.importe) != Float.floatToIntBits(other.importe)) {
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
        return true;
    }
    
   
}
