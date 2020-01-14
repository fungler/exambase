package DTO;

import entities.Cargo;

/**
 *
 * @author Martin
 */
public class CargoDTO {
    
    private Integer id;
    private String name;
    private double weight;
    private int units;

    public CargoDTO(Cargo c) {
        this.id = c.getId();
        this.name = c.getName();
        this.weight = c.getWeight();
        this.units = c.getUnits();
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    
    
}
