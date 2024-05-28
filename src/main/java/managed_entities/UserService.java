package managed_entities;

import dao.Database;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;



@Named("userservice")
@RequestScoped
public class UserService {

    @EJB
    Database db;

    private String name;
    private String password;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    //Services
    

    public String login() {
        if (db.found(name, password)) {
            return "homepage";
        } 
        else {
            return null;
        }
    }
    
}