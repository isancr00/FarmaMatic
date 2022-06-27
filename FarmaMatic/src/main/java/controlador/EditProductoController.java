/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProductoFacadeLocal;
import EJB.ProoveedorFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
public class EditProductoController implements Serializable{
    private Producto producto;
    private Prooveedor proveedor;
    private String nombreP;
    private List<Prooveedor> proveedores;

    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @EJB
    private ProoveedorFacadeLocal proveedoorEJB;
        
    @PostConstruct
    public void init(){
        producto = (Producto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("editar");
        proveedor = new Prooveedor();
        proveedores = proveedoorEJB.findAll();
    } 
    
    
    public void editar() throws IOException{
       proveedor = proveedoorEJB.getProvNombre(nombreP);
       if(proveedor != null){
            producto.setProoveedor(proveedor);
       }
      
       productoEJB.edit(producto);

         String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/FarmaMatic/faces/privado/productos.xhtml;jsessionid="+sessionId); 

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

    public Prooveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Prooveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }
    
     public List<String> proveedores(){
        ArrayList<String> nombres = new ArrayList<>();
        
        for(int i=0;i<proveedores.size();i++){
            nombres.add(proveedores.get(i).getNombre());
        }
        
        return nombres;
    }

    public List<Prooveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Prooveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ProoveedorFacadeLocal getProveedoorEJB() {
        return proveedoorEJB;
    }

    public void setProveedoorEJB(ProoveedorFacadeLocal proveedoorEJB) {
        this.proveedoorEJB = proveedoorEJB;
    }
     
     
    
    
   
}
