package controllers;

import java.util.List;

import annotations.Catch;
import models.StockItem;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.*;

@Catch
public class Product extends Controller{
	
	public Result index() {
		return redirect(routes.Product.list(1));
	}
	public Result list(int page) {
		return TODO;
	}
	public Result details(long ean) {
		return TODO;
	}
	public Result edit(long ean) {
		return TODO;
	}
	public Result save(long ean) {
		return TODO;
	}
//	public Result list(Long warehouseId) {
//		List<StockItem> stockItems = StockItem.find()
//				.where()
//				.eq("warehouse_id", warehouseId)
//				.findList();
//		if(request().accepts("text/plain")) {
//			return ok(StringUtils.join(stockItems, "\n"));
//		}
//		return ok(product.render(stockItems));
//	}
}
