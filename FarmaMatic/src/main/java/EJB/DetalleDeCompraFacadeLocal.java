/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.DetalleDeCompra;

/**
 *
 * @author sanch
 */
@Local
public interface DetalleDeCompraFacadeLocal {

    void create(DetalleDeCompra detalleDeCompra);

    void edit(DetalleDeCompra detalleDeCompra);

    void remove(DetalleDeCompra detalleDeCompra);

    DetalleDeCompra find(Object id);

    List<DetalleDeCompra> findAll();

    List<DetalleDeCompra> findRange(int[] range);

    int count();
    
}
