package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Shipment {
	
	@Id
	@GeneratedValue
	private int id;

	private String name;
    private String address;
    private double price;
    private boolean delivered;
    
  //CONSTRUCTORS
    
    public Shipment() {}
    
    public Shipment( String name, String address, double price, boolean delivered) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.delivered = delivered;
    }
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
        return "Shipment [id=" + id + ", name=" + name + ", address=" + address + ", price=" + price + ", delivered=" + delivered + "]";
    }
    
	//GETTERS AND SETTERS
    
}
