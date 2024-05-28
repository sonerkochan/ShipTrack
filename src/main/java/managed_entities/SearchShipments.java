package managed_entities;

import java.util.List;

import dao.Database;
import entities.Shipment;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;

@Named("searchshipments")
@RequestScoped
public class SearchShipments {
    private List<Shipment> allShipments;
    private List<Shipment> delivered;
    private List<Shipment> waiting;
    
    @EJB
    Database db;
    
    @PostConstruct
    public void init() {
    	allShipments = db.returnShipments();
    	delivered=db.returnDelivered();
    	waiting=db.returnWaiting();
    }

    public List<Shipment> getAllShipments() {
        return allShipments;
    }    

    public List<Shipment> getDelivered() {
        return delivered;
    }

    public List<Shipment> getWaiting() {
        return waiting;
    }
    
    public void allShipments() {
    	db.returnShipments();
    }

    public void allDeliveredShipments() {
    	db.returnDelivered();
    }

    public void AllWaitingShipments() {
    	db.returnWaiting();
    }

}
