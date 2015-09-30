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
	
	public static void addInit(Warehouse wh) {
		Product pd = new Product();
		pd.ean = 1L;
		pd.name = "Blue Paperclip 01";
		pd.description = "Blue Paperclip 01";
		pd.save();
		StockItem.addInit(pd, wh);
		
		pd = new Product();
		pd.ean = 2L;
		pd.name = "Red Paperclip 01";
		pd.description = "Red Paperclip 01";
		pd.save();
		StockItem.addInit(pd, wh);
		
		pd = new Product();
		pd.ean = 3L;
		pd.name = "Yellow Paperclip 01";
		pd.description = "Yellow Paperclip 01";
		pd.save();
		StockItem.addInit(pd, wh);
		
		pd = new Product();
		pd.ean = 4L;
		pd.name = "Black Paperclip 01";
		pd.description = "Black Paperclip 01";
		pd.save();
		StockItem.addInit(pd, wh);
	}
}
