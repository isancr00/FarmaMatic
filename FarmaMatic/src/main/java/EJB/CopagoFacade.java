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
import modelo.Copago;
import modelo.Prooveedor;

/**
 *
 * @author sanch
 */
@Stateless
public class CopagoFacade extends AbstractFacade<Copago> implements CopagoFacadeLocal {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CopagoFacade() {
        super(Copago.class);
    }

    @Override
    public Copago findPorcentaje(int porcentaje) {
           List<Copago> lista = this.findAll();
        
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getPorcentaje() == porcentaje){
                return lista.get(i);
            }
        }
        
        return null;


    }
    
}
