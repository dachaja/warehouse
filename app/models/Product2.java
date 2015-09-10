package models;

import com.avaje.ebean.Model;

public class Product2 extends Model{
	public Long ean;
	public String name;
	public String description;
	
	@Override
	public String toString() {
		return name;
	}
}
