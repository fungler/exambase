/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Martin
 */
@Entity
@Table(name="trucks")
public class Truck implements Serializable {

    public Truck() {
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;
    
    private int capacity;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    List<Driver> drivers = new ArrayList();
    
    @OneToOne(cascade=CascadeType.PERSIST)
    Delivery currDelivery;

    public Truck(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Driver> getDrivers() {
        return this.drivers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Delivery getCurrDelivery() {
        return currDelivery;
    }

    public void setCurrDelivery(Delivery currDelivery) {
        this.currDelivery = currDelivery;
    }
    
    public void setDrivers(List<Driver> trucks) {
        this.drivers = trucks;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Driver> getTrucks() {
        return this.drivers;
    }

    public void addDriver(Driver driver) 
    {
        this.drivers.add(driver);
        driver.addTruck(this);
    }
    
    public void addDelivery(Delivery delivery)
    {
        this.currDelivery = delivery;
        delivery.addTruck(this);
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Truck)) {
            return false;
        }
        Truck other = (Truck) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Truck[ id=" + id + " ]";
    }
    
}
