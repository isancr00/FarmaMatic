/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author sanch
 */

@Named
@ViewScoped
public class DetalleVentaController implements Serializable {
    
    private Venta venta;
    
    @EJB
    private ProductoFacadeLocal productoEJB;

    
    @PostConstruct
    public void init(){
        venta = (Venta) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("venta");
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public List<Producto> prod(){
        List<Producto> devuelve = new ArrayList<>();
        List<Producto> productos = productoEJB.findAll();
        
        for(int i=0;i<productos.size();i++){
            if(productos.get(i).getVenta() != null){
                if(productos.get(i).getVenta().equals(venta)){
                    devuelve.add(productos.get(i));
                }
            }
        }

        return devuelve;
    }
    
    public float precioTrasCopago(Producto producto,float pvp){
        float precio = 0;
        
        precio = pvp - pvp*venta.getCliente().getCopago().getPorcentaje()/100;
        
        
        
        return precio;
    }
    
}
