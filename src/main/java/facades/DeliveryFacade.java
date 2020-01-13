package facades;

import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class DeliveryFacade {

    private static DeliveryFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private DeliveryFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static DeliveryFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DeliveryFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Delivery> getAllDeliveries(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Delivery> allDel = em.createQuery("SELECT d FROM Delivery d").getResultList();
            return allDel;
        }finally{  
            em.close();
        }
    }
    
    public List<Truck> getAllTrucks(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Truck> allTrucks = em.createQuery("SELECT t FROM Truck t").getResultList();
            return allTrucks;
        }finally{  
            em.close();
        }
    }

    public List<Driver> getAllDrivers(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Driver> allDrivers = em.createQuery("SELECT d FROM Driver d").getResultList();
            return allDrivers;
        }finally{  
            em.close();
        }
    }
    
    public List<Cargo> getAllCargo(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Cargo> allCargo = em.createQuery("SELECT c FROM Cargo c").getResultList();
            return allCargo;
        }finally{  
            em.close();
        }
    }
}
