/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Prooveedor;

/**
 *
 * @author sanch
 */
@Local
public interface ProoveedorFacadeLocal {

    void create(Prooveedor prooveedor);

    void edit(Prooveedor prooveedor);

    void remove(Prooveedor prooveedor);

    Prooveedor find(Object id);

    List<Prooveedor> findAll();

    List<Prooveedor> findRange(int[] range);

    int count();

    public Prooveedor getProvNombre(String nombreProveedor);
    
}
