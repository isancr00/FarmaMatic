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
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    
    @Column(name = "caducidad")
    private Date caducidad;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "pvp")
    private float pvp;
    
    @Column(name = "iva")
    private int iva;
    
    @Column(name = "subvencionada")
    private boolean suvbencionada;
    
    @JoinColumn(name = "idProoveedor")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Prooveedor prooveedor;
    
     @JoinColumn(name = "idVenta")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Venta venta;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public boolean isSuvbencionada() {
        return suvbencionada;
    }

    public void setSuvbencionada(boolean suvbencionada) {
        this.suvbencionada = suvbencionada;
    }

    public Prooveedor getProoveedor() {
        return prooveedor;
    }

    public void setProoveedor(Prooveedor prooveedor) {
        this.prooveedor = prooveedor;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idProducto;
        hash = 41 * hash + Objects.hashCode(this.caducidad);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        hash = 41 * hash + Float.floatToIntBits(this.pvp);
        hash = 41 * hash + this.iva;
        hash = 41 * hash + (this.suvbencionada ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.prooveedor);
        hash = 41 * hash + Objects.hashCode(this.venta);
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
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (Float.floatToIntBits(this.pvp) != Float.floatToIntBits(other.pvp)) {
            return false;
        }
        if (this.iva != other.iva) {
            return false;
        }
        if (this.suvbencionada != other.suvbencionada) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.caducidad, other.caducidad)) {
            return false;
        }
        if (!Objects.equals(this.prooveedor, other.prooveedor)) {
            return false;
        }
        if (!Objects.equals(this.venta, other.venta)) {
            return false;
        }
        return true;
    }
    
    
}
