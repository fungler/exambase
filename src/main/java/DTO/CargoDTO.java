package DTO;

/**
 *
 * @author Martin
 */
public class CargoDTO {
    
    private Integer id;
    private String name;
    private double weight;
    private int units;

    public CargoDTO(String name, double weight, int units) {
        this.name = name;
        this.weight = weight;
        this.units = units;
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
