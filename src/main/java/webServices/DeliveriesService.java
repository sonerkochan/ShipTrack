package webServices;

import java.util.List;

import entities.Shipment;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import managed_entities.SearchShipments;

@Path("shipments")
public class DeliveriesService
{
	 @Inject
	    private SearchShipments service;

	    @GET
	    @Path("/delivered")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Shipment> getAllDeliveredShipments() {
	        return service.getDelivered();
	    }
	    

	    @GET
	    @Path("/waiting")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Shipment> getAllWaitingShipments() {
	        return service.getWaiting();
	    }
}
