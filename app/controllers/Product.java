package controllers;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import models.StockItem;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Product extends Controller{
	public Result list(Long warehouseId) {
		List<StockItem> stockItems = StockItem.find()
				.where()
				.eq("warehouse_id", warehouseId)
				.findList();
		if(request().accepts("text/plain")) {
			return ok(StringUtils.join(stockItems, "\n"));
		}
		return ok(product.render(stockItems));
	}
}
