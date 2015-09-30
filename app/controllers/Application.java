package controllers;

import java.util.List;

import models.Product;
import models.StockItem;
import models.Warehouse;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result index() {
    		Warehouse wh = Warehouse.addInit();
    		Product.addInit(wh); 
    		
    		List<StockItem> items = StockItem.find()
    				.where()
    				.ge("quantity", 300)
    				.orderBy("quantity")
    				.setMaxRows(10)
    				.findList();
    		return ok(items.toString());
    }

}
