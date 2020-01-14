package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Martin
 */
public class DeliveryDetailDTO {
    private int id;
    private String fromLocation;
    private String destination;
    private Date shipDate;
    private List<CargoDTO> cargo;
    private TruckDTO assignedTruck;
    private List<DriverDTO> drivers;

    public DeliveryDetailDTO() {
//        this.id = 0;
//        this.fromLocation = "";
//        this.destination = "";
//        this.shipDate = new Date();
//        this.cargo = new ArrayList();
//        this.assignedTruck = null;
//        this.drivers = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public List<CargoDTO> getCargo() {
        return cargo;
    }

    public void setCargo(List<CargoDTO> cargo) {
        this.cargo = cargo;
    }

    public TruckDTO getAssignedTruck() {
        return assignedTruck;
    }

    public void setAssignedTruck(TruckDTO assignedTruck) {
        this.assignedTruck = assignedTruck;
    }

    public List<DriverDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDTO> drivers) {
        this.drivers = drivers;
    }
    
    
    
}
