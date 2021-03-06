/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.ClienteFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Cliente;

/**
 *
 * @author sanch
 */
@Named
@ViewScoped
public class ClientesController implements Serializable{
    private List<Cliente> clientes;
    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    @PostConstruct
    public void init(){
        clientes = clienteEJB.findAll();
        cliente=new Cliente();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }
    
    public void eliminarCliente(Cliente cliente) throws IOException{
        clienteEJB.remove(cliente);
         String sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
      
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/FarmaMatic/faces/privado/clientes.xhtml;jsessionid="+sessionId); 

    }
    
    public String add(){
        return "addCliente.xhtml";
    }
    
    public String editarCliente(Cliente cliente){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editarCli", cliente);

        return "editarCli.xhtml";
    }
    
    
}
