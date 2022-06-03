/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Prooveedor;

/**
 *
 * @author sanch
 */
@Stateless
public class ProoveedorFacade extends AbstractFacade<Prooveedor> implements ProoveedorFacadeLocal {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProoveedorFacade() {
        super(Prooveedor.class);
    }

    @Override
    public Prooveedor getProvNombre(String nombreProveedor) {
        List<Prooveedor> lista = this.findAll();
        
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getNombre().equals(nombreProveedor)){
                return lista.get(i);
            }
        }
        
        return null;
    
    }
    
    
}
