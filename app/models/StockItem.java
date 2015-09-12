package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name="stockitem")
public class StockItem extends Model{
	
	@Id
	public Long id;
	
	@ManyToOne
	public Warehouse warehouse;
	
	@ManyToOne
	public Product2 product;
	public Long quantity;
	
	@Override
	public String toString() {
		return String.format("%d %s", quantity, product);
	}
}
