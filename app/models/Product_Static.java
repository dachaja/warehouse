package models;

import java.util.HashSet;
import java.util.Set;

public class Product_Static {
	private static Set<Product_Static> products = new HashSet<Product_Static>();
	
	static {
		products.add(new Product_Static(1111111111111L, "Paperclips 1", "Paperclips description 1"));
		products.add(new Product_Static(2222222222222L, "Paperclips 2", "Paperclips description 2"));
		products.add(new Product_Static(3333333333333L, "Paperclips 3", "Paperclips description 3"));
		products.add(new Product_Static(4444444444444L, "Paperclips 4", "Paperclips description 4"));
		products.add(new Product_Static(5555555555555L, "Paperclips 5", "Paperclips description 5"));
	}
	
	public Long ean;
	public String name;
	public String description;
	
	public Product_Static() { }
	
	public Product_Static(Long ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;
	}
	
	public String toString() {
		return String.format("%s - %s", ean, name);
	}
	
	public static Set<Product_Static> findAll() {
		return new HashSet<Product_Static>(products);
	}
	
	public static Product_Static findByEan(Long ean) {
		for(Product_Static candidate : products) {
			if(candidate.ean.equals(ean)) {
				return candidate;
			}
		}
		return null;
	}
	
	public static Set<Product_Static> findByName(String term) {
		final Set<Product_Static> results = new HashSet<Product_Static>();
		for (Product_Static candidate : products) {
			if(candidate.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(candidate);
			}
		}
		return results;
	}
	
	public static boolean remove(Product_Static product) {
		return products.remove(product);
	}
	
	public static void add(Product_Static product) {
		products.add(product);
	}
}
