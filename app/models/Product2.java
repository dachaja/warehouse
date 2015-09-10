package models;

public class Product2 {
	public Long ean;
	public String name;
	public String description;
	
	@Override
	public String toString() {
		return name;
	}
}
