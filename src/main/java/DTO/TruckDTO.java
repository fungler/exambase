package DTO;

import entities.Truck;

/**
 *
 * @author Martin
 */
public class TruckDTO {
    
    private Integer id;
    private String name;
    private int capacity;

    public TruckDTO(Truck t) {
        this.id = t.getId();
        this.name = t.getName();
        this.capacity = t.getCapacity();
    }

    public TruckDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
