/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Producto;

/**
 *
 * @author sanch
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    public List<Producto> productosCaducados() {
        List<Producto> tirar = new ArrayList<>();
        List<Producto> listaDeProductos = this.findAll();
        
        for(int i=0;i<listaDeProductos.size();i++){
            //Meto los productos que caducan este mes
            
            Date hoy = new Date();
            Date caducidad = listaDeProductos.get(i).getCaducidad();
            
            if(caducidad.before(hoy)){
                tirar.add(listaDeProductos.get(i));
            }
            
        }
        return tirar;
    }
    
}
