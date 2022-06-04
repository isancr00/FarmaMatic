/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.DetalleDeVentaFacadeLocal;
import EJB.VentaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.DetalleDeVenta;
import modelo.Venta;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class DispensacionController implements Serializable{
    
    @EJB
    private VentaFacadeLocal ventaEJB;
    
    @EJB
    private DetalleDeVentaFacadeLocal detalleVentaEJB;
    
    private List<Venta> ventas;
    
    @PostConstruct
    public void init(){
        ventas = ventaEJB.findAll();
    }

    public VentaFacadeLocal getVentaEJB() {
        return ventaEJB;
    }

    public void setVentaEJB(VentaFacadeLocal ventaEJB) {
        this.ventaEJB = ventaEJB;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    
    
    public float importeIdVenta(int idVenta){
        float importe = 0;
        
        for(int i=0;i<ventas.size();i++){
            
            if(ventas.get(i).getIdVenta() == idVenta){
                return ventas.get(i).getDetVenta().getImporte();
            }
        }
        
        
        return importe;
        
    }
    
    public String add(){
        return "addVenta.xhtml";
    }
    
    
}
