/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
import EJB.CopagoFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
public class EditClienteController implements Serializable{
    
    private Cliente cliente;
    private Copago copago;
    private int copagoNum;
    private List<Copago> copagos;
    
    
    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    
    @EJB
    private CopagoFacadeLocal copagoEJB;
        
        
    @PostConstruct
    public void init(){
        cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("editarCli");
        copago = new Copago();
        copagos = copagoEJB.findAll();
    }
    
    public void editar() throws IOException{
        copago = copagoEJB.findPorcentaje(copagoNum);
        
        if(copago != null){
            cliente.setCopago(copago);
        }
        
        clienteEJB.edit(cliente);
        
         String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/FarmaMatic/faces/privado/clientes.xhtml;jsessionid="+sessionId); 

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Copago getCopago() {
        return copago;
    }

    public void setCopago(Copago copago) {
        this.copago = copago;
    }

    public int getCopagoNum() {
        return copagoNum;
    }

    public void setCopagoNum(int copagoNum) {
        this.copagoNum = copagoNum;
    }

    public List<Copago> getCopagos() {
        return copagos;
    }

    public void setCopagos(List<Copago> copagos) {
        this.copagos = copagos;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public CopagoFacadeLocal getCopagoEJB() {
        return copagoEJB;
    }

    public void setCopagoEJB(CopagoFacadeLocal copagoEJB) {
        this.copagoEJB = copagoEJB;
    }
    
    
    public List<Integer> copagos(){
        ArrayList<Integer> cop = new ArrayList<>();
        
        for(int i=0;i<copagos.size();i++){
            cop.add(copagos.get(i).getPorcentaje());
        }
        
        
        return cop;
    }
    
}
