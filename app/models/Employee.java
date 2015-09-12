package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	public Long id;
	
	public String firstName;
	public String lastName;
	
	@ManyToMany
	public List<Warehouse> warehouse;
}
