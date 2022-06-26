/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.Copago;

/**
 *
 * @author sanch
 */
@Local
public interface CopagoFacadeLocal {

    void create(Copago copago);

    void edit(Copago copago);

    void remove(Copago copago);

    Copago find(Object id);

    List<Copago> findAll();

    List<Copago> findRange(int[] range);
    Copago findPorcentaje(int porcentaje);
    
    

    int count();
    
}
