package models;

public class StockItem {
	public Warehouse warehouse;
	public Product2 product;
	public Long quantity;
	
	@Override
	public String toString() {
		return String.format("%d %s", quantity, product);
	}
}
