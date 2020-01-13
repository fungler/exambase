package rest;

import DTO.CargoDTO;
import DTO.DeliveryDTO;
import DTO.DriverDTO;
import DTO.TruckDTO;
import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import utils.EMF_Creator;
import facades.DeliveryFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("delivery")
public class RenameMeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final DeliveryFacade FACADE =  DeliveryFacade.getFacadeExample(EMF);
    //private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
//    
//    public <D, O> D convertToDTO(List<O> toConvert)
//    {
//        D prototype;
//        Field[] orgFields = prototype.getClass().getDeclaredFields();
//        
//        List<D> ret = new ArrayList();
//        
//        for (O original : toConvert)
//        {
//            ret.add(new D(O.get));
//        }
//    }
    
    @GET
    @Path("alldeliveries")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DeliveryDTO> getAllDeliveries() {
        
        List<Delivery> foundDeliveries = FACADE.getAllDeliveries();
        List<DeliveryDTO> toDTO = new ArrayList();
        
        for (Delivery d : foundDeliveries)
        {
            toDTO.add(new DeliveryDTO(d.getShipDate(), d.getFromLocation(), d.getDestination()));
        }       
        
        return toDTO;
    }
    
    @GET
    @Path("alltrucks")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TruckDTO> getAllTrucks() {
        
        List<Truck> foundTrucks = FACADE.getAllTrucks();
        List<TruckDTO> toDTO = new ArrayList();
        
        for (Truck t : foundTrucks)
        {
            toDTO.add(new TruckDTO(t.getName(), t.getCapacity()));
        }
        
        return toDTO;
    }

    @GET
    @Path("alldrivers")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DriverDTO> getAllDrivers() {
        
        List<Driver> foundDrivers = FACADE.getAllDrivers();
        List<DriverDTO> toDTO = new ArrayList();
        
        for (Driver t : foundDrivers)
        {
            toDTO.add(new DriverDTO(t.getName()));
        }
        
        return toDTO;
    }
    
    @GET
    @Path("allcargo")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CargoDTO> getAllCargo() {
        
        List<Cargo> foundCargo = FACADE.getAllCargo();
        List<CargoDTO> toDTO = new ArrayList();
        
        for (Cargo c : foundCargo)
        {
            toDTO.add(new CargoDTO(c.getName(), c.getWeight(), c.getUnits()));
        }
        
        return toDTO;
    }
}
