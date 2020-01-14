package DTO;

import entities.Driver;

/**
 *
 * @author Martin
 */
public class DriverDTO {
    
    private Integer id;
    private String name;

    public DriverDTO() {
    }

    
    public DriverDTO(Driver d) {
        this.id = d.getId();
        this.name = d.getName();
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
    
    
}
