/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
import EJB.CopagoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Cliente;
import modelo.Copago;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class AltaClienteController implements Serializable {
    private Cliente cliente;
    private List<Copago> copagos;
    private String porcentaje;

    
    @EJB
    private CopagoFacadeLocal copagoEJB; 
    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    @PostConstruct
    
    public void init(){
        cliente = new Cliente();
        copagos = copagoEJB.findAll();
    }  
    
    
    
    public void addCliente(){
      try{
            cliente.setCopago(copagoEJB.findPorcentaje(Integer.parseInt(porcentaje)));
            clienteEJB.create(cliente);
        }catch(Exception e){
            System.out.println("Error insertando cliente "+e.getMessage());

        }  
    }
    
       
    public List<String> copagos(){
        ArrayList<String> nombre = new ArrayList<>();
        
        for(int i=0;i<this.copagos.size();i++){
            nombre.add(Integer.toString(copagos.get(i).getPorcentaje()));
        }
        
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Copago> getCopagos() {
        return copagos;
    }

    public void setCopagos(List<Copago> copagos) {
        this.copagos = copagos;
    }

    public CopagoFacadeLocal getCopagoEJB() {
        return copagoEJB;
    }

    public void setCopagoEJB(CopagoFacadeLocal copagoEJB) {
        this.copagoEJB = copagoEJB;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }


}
