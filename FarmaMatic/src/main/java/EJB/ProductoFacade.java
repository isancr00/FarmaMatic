/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Producto;
import modelo.Venta;

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
            
            
            if(listaDeProductos.get(i).getVenta() == null){
                if(caducidad.before(hoy)){
                    tirar.add(listaDeProductos.get(i));
                }   
            }
            
            
        }
        return tirar;
    }

    @Override
    public List<String> getListaNombres() {
          ArrayList<String> nombres = new ArrayList<>();
          List<Producto> prod = this.findAll();

          for(int i=0;i<prod.size();i++){
              nombres.add(prod.get(i).getNombre());
          }


          return nombres;
    }

    @Override
    public List<Producto> findVender() {
        
        
        List<Producto> prod = this.findAll();
        List<Producto> vender = new ArrayList<>();


          for(int i=0;i<prod.size();i++){
              if(prod.get(i).getVenta()==null){
                  vender.add(prod.get(i));
              }

          }
          
          return vender;
    }

    @Override
    public void vender(Producto producto,Venta venta) {
        List<Producto> prod = this.findAll();
        
        for(int i=0;i<prod.size();i++){
            if(prod.get(i).equals(producto)){
                prod.get(i).setVenta(venta);
            }
        }
        
        
        
    }

    @Override
    public List<Producto> findNoVendidos() {
        List<Producto> prod = this.findAll();
        List<Producto> noVendidos = new ArrayList<>();

        
        for(int i=0;i<prod.size();i++){
            if(prod.get(i).getVenta() == null){
                noVendidos.add(prod.get(i));
            }
        }
        
        return noVendidos;
    }

    
    
}
