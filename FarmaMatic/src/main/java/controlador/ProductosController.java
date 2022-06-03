/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProductoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producto;
import org.primefaces.PrimeFaces;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class ProductosController implements Serializable{
    private List<Producto> productos;
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @PostConstruct
    public void init(){
        productos = productoEJB.findAll();
    }
    
    public void eliminarProducto(Producto producto) throws IOException{
        productoEJB.remove(producto);

    }
    
    public String add(){
        return "addProducto.xhtml";
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }
}
