package managed_entities;


import java.io.IOException;

import dao.Database;
import entities.Shipment;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Named("shipmentservice")
@RequestScoped
public class ShipmentService {
    

    @PersistenceContext
    private EntityManager em;
	
    @EJB
    Database db;

	private String name;
    private String address;
    private double price;
    private boolean delivered;
    
 

    
    public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Transactional 
	public void markAsDelivered(Shipment shipment) {
        shipment.setDelivered(true);
        em.merge(shipment);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        try {
            externalContext.redirect("homepage.jsf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
    public String send() {
        if (name != null && address != null && price>0) {
            
        	Shipment shipment = new Shipment(name, address, price,false);

            db.addShipment(shipment);
            return "homepage";
        } 
        else {
            return null; 
        }
    }

	
}
