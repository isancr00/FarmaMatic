/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.DetalleDeVenta;

/**
 *
 * @author sanch
 */
@Local
public interface DetalleDeVentaFacadeLocal {

    void create(DetalleDeVenta detalleDeVenta);

    void edit(DetalleDeVenta detalleDeVenta);

    void remove(DetalleDeVenta detalleDeVenta);

    DetalleDeVenta find(Object id);

    List<DetalleDeVenta> findAll();

    List<DetalleDeVenta> findRange(int[] range);

    int count();
    
}
