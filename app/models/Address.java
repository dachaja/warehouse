package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;

@Entity
public class Address extends Model{
	@Id
	public Long id;
	@OneToOne(mappedBy="address")
	public Warehouse warehouse;
	
	public String street;
	public String number;
	public String postalCode;
	public String city;
	public String country;
	
	public static Address addInit(Warehouse wh) {
		Address addr = new Address();
		addr.city = "Burnaby";
		addr.country = "Canada";
		addr.number = "7655";
		addr.street = "Edmonds st";
		addr.postalCode = "V3N 1B6";
		addr.warehouse = wh;
		addr.save();
		
		return addr;
	}
}
