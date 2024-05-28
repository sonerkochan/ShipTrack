package entities;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Shipment.class)
public abstract class Shipment_ {

	public static volatile SingularAttribute<Shipment, String> address;
	public static volatile SingularAttribute<Shipment, Double> price;
	public static volatile SingularAttribute<Shipment, String> name;
	public static volatile SingularAttribute<Shipment, Boolean> delivered;
	public static volatile SingularAttribute<Shipment, Integer> id;

	public static final String ADDRESS = "address";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DELIVERED = "delivered";
	public static final String ID = "id";

}

