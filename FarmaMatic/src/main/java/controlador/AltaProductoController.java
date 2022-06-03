/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProductoFacadeLocal;
import EJB.ProoveedorFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producto;
import modelo.Prooveedor;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class AltaProductoController implements Serializable {
    private Producto producto;
    private List<Prooveedor> proveedores;
    private int cantidad;
    private Prooveedor proveedor;
    private String nombreProveedor;
    
    @EJB
    private ProoveedorFacadeLocal proveedorEJB; 
    
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @PostConstruct
    
    public void init(){
        producto = new Producto();
        proveedores = proveedorEJB.findAll();
        proveedor = new Prooveedor();
    }  
    
    
    public void insertarProductos(){
        try{
            proveedor = proveedorEJB.getProvNombre(nombreProveedor);
            producto.setProoveedor(proveedor);
            
            for(int i=0;i<cantidad;i++){
                productoEJB.create(producto);

            }
            
        }catch (Exception e){
            System.out.println("Error insertando producto "+e.getMessage());
        }
    }
    
    public List<String> proveedores(){
        ArrayList<String> nombres = new ArrayList<>();
        
        for(int i=0;i<proveedores.size();i++){
            nombres.add(proveedores.get(i).getNombre());
        }
        
        return nombres;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }

    public List<Prooveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Prooveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Prooveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Prooveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public ProoveedorFacadeLocal getProveedorEJB() {
        return proveedorEJB;
    }

    public void setProveedorEJB(ProoveedorFacadeLocal proveedorEJB) {
        this.proveedorEJB = proveedorEJB;
    }
    
        
}
