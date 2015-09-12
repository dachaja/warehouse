package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Warehouse{
	@Id
	public Long id;
	public String name;
	@OneToOne
	public Address address;
	
	@OneToMany
	public List<StockItem> stock = new ArrayList<>();
	
	@ManyToMany
	@JoinColumn(name="id")
	public List<Employee> employees;
	
	@Override 
	public String toString() {
		return name;
	}
}
