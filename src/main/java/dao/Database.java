package dao;

import entities.Shipment;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class Database {

    @PersistenceContext(unitName="JPADefaultDataBaseConnection")
    private EntityManager em;

    public void addShipment(Shipment s) {
        em.persist(s);
    }

    public List<Shipment> returnShipments() {
        return em.createQuery("SELECT s FROM Shipment s", Shipment.class).getResultList();
    }
    
    public List<Shipment> returnDelivered() {
        return em.createQuery("SELECT s FROM Shipment s WHERE s.delivered = true", Shipment.class).getResultList();
    }
    
    public List<Shipment> returnWaiting() {
        return em.createQuery("SELECT s FROM Shipment s WHERE s.delivered = false", Shipment.class).getResultList();
    }
    
    
    public List<User> returnUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    
    public boolean found(String name, String password) {
        List<User> allUsers = returnUsers();

        return allUsers != null && allUsers.stream()
                .anyMatch(user -> user.getName().equals(name) && user.getPassword().equals(password));
    }
}
