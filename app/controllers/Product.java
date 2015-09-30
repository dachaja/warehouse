package controllers;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import models.StockItem;
import play.mvc.Controller;
import play.mvc.Result;

public class Product extends Controller{
	public Result list(Long warehouseId) {
		List<StockItem> stockItems = StockItem.find()
				.where()
				.eq("id", warehouseId)
				.findList();
		return ok(StringUtils.join(stockItems, "\n"));
	}
}
