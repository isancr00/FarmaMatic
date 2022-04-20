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
@Table(name = "detalleDeCompra")
public class DetalleDeCompra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleCompra;
    
    @Column(name = "importe")
    private int importe;
    
    @JoinColumn(name = "idCompra")
    private Compra compra;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "detalleCompraProd", joinColumns = @JoinColumn(name = "idCompra"), inverseJoinColumns = @JoinColumn(name = "idProducto"))
    private List<Producto> productos;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idDetalleCompra;
        hash = 71 * hash + this.importe;
        hash = 71 * hash + Objects.hashCode(this.compra);
        hash = 71 * hash + Objects.hashCode(this.productos);
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
        final DetalleDeCompra other = (DetalleDeCompra) obj;
        if (this.idDetalleCompra != other.idDetalleCompra) {
            return false;
        }
        if (this.importe != other.importe) {
            return false;
        }
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        if (!Objects.equals(this.productos, other.productos)) {
            return false;
        }
        return true;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
}
