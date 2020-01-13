package facades;

import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class DeliveryFacadeTest {

    private static EntityManagerFactory emf;
    private static DeliveryFacade facade;

    public DeliveryFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/exambase_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = DeliveryFacade.getFacadeExample(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = DeliveryFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {

    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        Driver d1 = new Driver("John Doe");
        Truck t1 = new Truck("Truck 1", 100);
        Cargo c1 = new Cargo("Toilet paper", 20, 400);
        Cargo c2 = new Cargo("Lego", 10, 300);
        Cargo c3 = new Cargo("Bricks", 600, 300);
        Delivery del1 = new Delivery("a", "b");
        Delivery del2 = new Delivery("c", "d");

        t1.addDriver(d1);
        t1.addDelivery(del1);
        del1.addCargo(c1);
        del1.addCargo(c2);
        del2.addCargo(c3);

        try {
            em.getTransaction().begin();

            em.createQuery("delete from Truck").executeUpdate();
            em.createQuery("delete from Driver").executeUpdate();
            em.createQuery("delete from Cargo").executeUpdate();

            em.persist(d1);
            em.persist(t1);
            em.persist(del1);
            em.persist(del2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testGetAllDrivers() {
        assertEquals(1, facade.getAllDrivers().size());
    }

    @Test
    public void testGetAllDeliveries() {
        assertEquals(2, facade.getAllDeliveries().size());
    }

    @Test
    public void testGetAllTrucks() {
        assertEquals(1, facade.getAllTrucks().size());
    }
    
    @Test
    public void testGetAllCargo() {
        assertEquals(3, facade.getAllCargo().size());
    }

}
