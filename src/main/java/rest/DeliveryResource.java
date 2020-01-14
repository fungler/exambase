package rest;

import DTO.CargoDTO;
import DTO.DeliveryDTO;
import DTO.DeliveryDetailDTO;
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
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("delivery")
public class DeliveryResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final DeliveryFacade FACADE =  DeliveryFacade.getFacadeExample(EMF);
    //private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;
    @Context
    SecurityContext securityContext;
    
    @GET
    @Path("alldeliveries")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DeliveryDTO> getAllDeliveries() {
        
        List<Delivery> foundDeliveries = FACADE.getAllDeliveries();
        List<DeliveryDTO> toDTO = new ArrayList();
        
        for (Delivery d : foundDeliveries)
        {
            toDTO.add(new DeliveryDTO(d));
        }       
        
        return toDTO;
    }
    
    @GET
    @Path("alltrucks")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TruckDTO> getAllTrucks() {
        
        List<Truck> foundTrucks = FACADE.getAllTrucks();
        List<TruckDTO> toDTO = new ArrayList();
        
        for (Truck t : foundTrucks)
        {
            toDTO.add(new TruckDTO(t));
        }
        
        return toDTO;
    }

    @GET
    @Path("alldrivers")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DriverDTO> getAllDrivers() {
        
        List<Driver> foundDrivers = FACADE.getAllDrivers();
        List<DriverDTO> toDTO = new ArrayList();
        
        for (Driver d : foundDrivers)
        {
            toDTO.add(new DriverDTO(d));
        }
        
        return toDTO;
    }
    
    @GET
    @Path("allcargo")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CargoDTO> getAllCargo() {
        
        List<Cargo> foundCargo = FACADE.getAllCargo();
        List<CargoDTO> toDTO = new ArrayList();
        
        for (Cargo c : foundCargo)
        {
            toDTO.add(new CargoDTO(c));
        }
        
        return toDTO;
    }
    
    @PUT
    @Path("editdriver/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public DriverDTO editDriver(@PathParam("id") int id, DriverDTO driver) {
        DriverDTO ddto = new DriverDTO(FACADE.editDriver(id, driver));
        return ddto;
    }
    
    @DELETE
    @Path("deletedriver/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean deleteDriver(@PathParam("id") int id) {
        FACADE.deleteDriver(id);
        return true;
    }
    
    @POST
    @Path("createdriver")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public boolean createDriver(String name) {
        String res = name.substring(1, name.length() - 1);
        FACADE.addDriver(res);
        return true;
    }
    
    @PUT
    @Path("edittruck/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public TruckDTO editTruck(@PathParam("id") int id, TruckDTO truck) {
        TruckDTO ddto = new TruckDTO(FACADE.editTruck(id, truck));
        return ddto;
    }
    
    @DELETE
    @Path("deletetruck/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public boolean deleteTruck(@PathParam("id") int id) {
        FACADE.deleteTruck(id);
        return true;
    }
    
    @POST
    @Path("createtruck")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public boolean createTruck(TruckDTO truck) {
        FACADE.addTruck(truck);
        return true;
    }
    
    @GET
    @Path("getdeliverydetails/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    public DeliveryDetailDTO getAllCargo(@PathParam("id") int id) {
        return FACADE.getDeliveryInfo(id);
    }
}
