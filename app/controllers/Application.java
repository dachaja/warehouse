package controllers;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result index() {
//        Warehouse warehouse = new Warehouse();
//        warehouse.name = "My Warehouse";
//        
//        Product product = new Product();
//        product.name = "Stainless steel paperclips, small, 1000pcs";
//        product.ean = 1234567891231L;
//        product.description = "1000 blue paperclips.";
//        product.save();
//        
//        StockItem item = new StockItem();
//        item.quantity = 15L;
//        item.product = product;
//        
//        item.warehouse = warehouse;
//        warehouse.stock.add(item);
//        Address addr = new Address();
//        addr.city = "Rotterdam";
//        addr.country = "Netherlands";
//        addr.number = "70";
//        addr.street = "Heemraadssingel";
//        addr.postalCode = "3021DD";
//        addr.warehouse = warehouse;
//        warehouse.address = addr;
//        addr.save();
//        warehouse.save();
//        item.save();
        
//        List<String> output = new LinkedList<String>();
//        output.add(String.format("My warehouse is called '%s'", warehouse));
//        output.add(String.format("It contains %d items", warehouse.stock.size()));
//        output.add(String.format("The first is: %s", warehouse.stock.get(0)));
        
        //Product pd = Ebean.find(Product.class, 1L);
//        Product pd = Product.find().byId(1L);
//        Logger.info(String.format("Product name: %s", pd.name));
//        Logger.info(String.format("StockItems: %d", pd.stockItems.size()));
//
//        return ok(String.format("Product name: %s", pd.name));
    	
//    		List<StockItem> items = StockItem.find().findList();
//    		List<StockItem> items = StockItem.find()
//    				.where()
//    				.ge("quantity", 300)
//    				.orderBy("quantity")
//    				.setMaxRows(10)
//    				.findList();
//    		return ok(items.toString());
    		Product.addInit(); 
    		return ok();
    }

}
