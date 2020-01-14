package utils;


import entities.Cargo;
import entities.Delivery;
import entities.Role;
import entities.User;
import entities.Driver;
import entities.Truck;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    //test ;D
    
    User user = new User("user", "test");
    User admin = new User("admin", "test");
    User both = new User("user_admin", "test");
    
    Driver d1 = new Driver ("John Doe");
    Driver d2 = new Driver ("Jimmy Joe");
    Driver d3 = new Driver ("Big Boi");
    Truck t1 = new Truck("Truck 1", 100);
    Cargo c1 = new Cargo("Toilet paper", 20, 400);
    Cargo c2 = new Cargo("Lego", 10, 300);
    Cargo c3 = new Cargo("Dildo", 600, 300);
    Delivery del1 = new Delivery("a", "b");
    Delivery del2 = new Delivery("c", "d");

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    
    t1.addDriver(d1);
    t1.addDelivery(del1);
    del1.addCargo(c1);
    del1.addCargo(c2);
    del2.addCargo(c3);
    
    em.persist(d1);
    em.persist(d2);
    em.persist(d3);
    em.persist(t1);
    em.persist(del1);
    em.persist(del2);
    
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test123"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}
