package DTO;

import entities.Delivery;
import java.util.Date;

/**
 *
 * @author Martin
 */
public class DeliveryDTO {
    
    private Integer id;
    private Date shipDate;
    private String fromLocation;
    private String destination;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Delivery d) {
        this.id = d.getId();
        this.shipDate = d.getShipDate();
        this.fromLocation = d.getFromLocation();
        this.destination = d.getDestination();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
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
    
}
