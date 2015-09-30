package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

@Entity
@Table(name="stockitem")
public class StockItem extends Model{
	
	@Id
	public Long id;
	
	@ManyToOne
	public Warehouse warehouse;
	
	@ManyToOne
	public Product product;
	public Long quantity;
	
	public static Finder<Long, StockItem> find() {
		return new Finder<>(StockItem.class);
	}
	
	@Override
	public String toString() {
		return String.format("StockItem %d - %d product %s", 
				id, quantity, product == null ? null : product.id);
	}
	
	public static void addInit(Product pd) {
		StockItem item = new StockItem();
		item.quantity = 10L;
		item.product = pd;
		item.save();
	}
}
