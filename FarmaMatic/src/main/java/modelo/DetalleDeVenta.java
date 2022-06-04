/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author sanch
 */
@Entity
@Table(name = "detalleDeVenta")
public class DetalleDeVenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;
    
    @Column(name = "importe")
    private float importe;    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "detalleVentaProd", joinColumns = @JoinColumn(name = "idVenta"), inverseJoinColumns = @JoinColumn(name = "idProducto"))
    private List<Producto> productos;

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idDetalleVenta;
        hash = 13 * hash + Float.floatToIntBits(this.importe);
        hash = 13 * hash + Objects.hashCode(this.productos);
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
        final DetalleDeVenta other = (DetalleDeVenta) obj;
        if (this.idDetalleVenta != other.idDetalleVenta) {
            return false;
        }
        if (Float.floatToIntBits(this.importe) != Float.floatToIntBits(other.importe)) {
            return false;
        }
        if (!Objects.equals(this.productos, other.productos)) {
            return false;
        }
        return true;
    }

    
    
    
    
    }
