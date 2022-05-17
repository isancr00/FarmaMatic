/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.DetalleDeCompra;

/**
 *
 * @author sanch
 */
@Stateless
public class DetalleDeCompraFacade extends AbstractFacade<DetalleDeCompra> implements DetalleDeCompraFacadeLocal {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDeCompraFacade() {
        super(DetalleDeCompra.class);
    }
    
}
