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
import javax.persistence.Query;
import modelo.Empleado;

/**
 *
 * @author sanch
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
    @Override
    public Empleado verificarEmpleado(Empleado empleado) {
        Empleado devuelve = null;
        String consulta = "FROM Empleado e WHERE e.nombreUsuario=:param1 and e.contrasenia=:param2";
        Query query = em.createQuery(consulta);
        
        query.setParameter("param1", empleado.getNombreUsuario());
        query.setParameter("param2", empleado.getContrasenia());
        
        List<Empleado> resultado = query.getResultList();
        
        if(resultado.isEmpty()){
            return null;
        }else{
            devuelve = resultado.get(0);
            return devuelve;
        }
    }
}
