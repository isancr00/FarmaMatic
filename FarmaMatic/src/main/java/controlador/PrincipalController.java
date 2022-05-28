/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producto;

/**
 *
 * @author sanch
 */

@Named
@ViewScoped
public class PrincipalController implements Serializable{
    
    private List<Producto> productosCaducados;
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @PostConstruct
    public void init(){
        productosCaducados = productoEJB.productosCaducados();
    }

    public List<Producto> getProductosCaducados() {
        return productosCaducados;
    }

    public void setProductosCaducados(List<Producto> productos) {
        this.productosCaducados = productos;
    }

    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }
    
    
    
    
}
