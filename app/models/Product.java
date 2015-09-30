package models;

import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
@Table(name="product")
public class Product extends Model{
	@Id
	public Long id;
	public Long ean;
	public String name;
	public String description;
	
	@OneToMany
	public List<StockItem> stockItems;
	
	public static Finder<Long, Product> find() {
		return new Finder<>(Product.class);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void addInit() {
		Product pd = new Product();
		pd.ean = 1L;
		pd.name = "Blue Paperclip 01";
		pd.description = "Blue Paperclip 01";
		pd.save();
		StockItem.addInit(pd);
	}
}
