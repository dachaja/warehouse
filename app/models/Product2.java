package models;

import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name="product2")
public class Product2 extends Model{
	@Id
	public Long id;
	public Long ean;
	public String name;
	public String description;
	
	@OneToMany
	public List<StockItem> stockItems;
	
	@Override
	public String toString() {
		return name;
	}
}
