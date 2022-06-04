/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
import EJB.DetalleDeVentaFacadeLocal;
import EJB.ProductoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Cliente;
import modelo.DetalleDeVenta;
import modelo.Empleado;
import modelo.Producto;
import modelo.Venta;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class AltaVentaController implements Serializable{
    
    private Empleado empleado;
    private Venta venta;
    private List<Cliente> clientes;
    private String nombreCliente;
    private List<Producto> seleccionados;
    
    private List<Producto> productos;
    
    private DetalleDeVenta detalle;

    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
     
    @EJB
    private ProductoFacadeLocal productoEJB;
    
    @EJB
    private DetalleDeVentaFacadeLocal detalleDeVentaFacadeLocal;
    
    @PostConstruct
    public void init(){
        empleado = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("c"); 
        clientes = clienteEJB.findAll();
        seleccionados = new ArrayList<>();
        productos = productoEJB.findAll();
    }

    public List<String> clientes(){
         ArrayList<String> nombres = new ArrayList<>();
        
        for(int i=0;i<clientes.size();i++){
            nombres.add(clientes.get(i).getNombreCliente());
        }
        
        return nombres;
    }

    public void add(){
        
        venta.setFechaVenta(new Date());
        venta.setEmpleado(empleado);
        
      
        
        
        
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public List<Producto> getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(List<Producto> seleccionados) {
        this.seleccionados = seleccionados;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public DetalleDeVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleDeVenta detalle) {
        this.detalle = detalle;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public ProductoFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(ProductoFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }

    public DetalleDeVentaFacadeLocal getDetalleDeVentaFacadeLocal() {
        return detalleDeVentaFacadeLocal;
    }

    public void setDetalleDeVentaFacadeLocal(DetalleDeVentaFacadeLocal detalleDeVentaFacadeLocal) {
        this.detalleDeVentaFacadeLocal = detalleDeVentaFacadeLocal;
    }
    
    
    
}
