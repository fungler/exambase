package facades;

import DTO.DriverDTO;
import DTO.TruckDTO;
import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    
    public Driver editDriver(int id, DriverDTO driver)
    {
        EntityManager em = emf.createEntityManager();
        Driver foundDriver = em.find(Driver.class, id);
        if (foundDriver == null)
            return null;
        
        foundDriver.setName(driver.getName());

        try{
            em.getTransaction().begin();
            em.merge(foundDriver);
            em.getTransaction().commit();
            
            return foundDriver;
        } finally{
            em.close();
        }
    }
    
    public void deleteDriver(int id)
    {
        EntityManager em = emf.createEntityManager();
        Driver foundDriver = em.find(Driver.class, id);

        if (foundDriver == null)
            return;
        
        try{
            em.getTransaction().begin();
            em.remove(foundDriver);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
    public void addDriver(String name)
    {
        EntityManager em = emf.createEntityManager();
        Driver toCreate = new Driver(name);
        
        try{
            em.getTransaction().begin();
            em.persist(toCreate);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
    public Truck editTruck(int id, TruckDTO truck)
    {
        EntityManager em = emf.createEntityManager();
        Truck foundTruck = em.find(Truck.class, id);
        
        if (foundTruck == null)
            return null;
        
        foundTruck.setName(truck.getName());
        foundTruck.setCapacity(truck.getCapacity());

        try{
            em.getTransaction().begin();
            em.merge(foundTruck);
            em.getTransaction().commit();
            
            return foundTruck;
        } finally{
            em.close();
        }
    }
    
    public void deleteTruck(int id)
    {
        EntityManager em = emf.createEntityManager();
        Truck foundTruck = em.find(Truck.class, id);

        if (foundTruck == null)
            return;
        
        try{
            em.getTransaction().begin();
            em.remove(foundTruck);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
    public void addTruck(TruckDTO truck)
    {
        EntityManager em = emf.createEntityManager();
        Truck toCreate = new Truck(truck.getName(), truck.getCapacity());
        
        try{
            em.getTransaction().begin();
            em.persist(toCreate);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
    
}
