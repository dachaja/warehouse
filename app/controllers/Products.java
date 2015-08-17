package controllers;

import java.util.Set;

import models.Product;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Products extends Controller{
	public Result list() {
		Set<Product> products = Product.findAll();
		return ok(list.render(products));
	}
	public Result showBlank() {
		return TODO;
	}
	public Result show(Long ean) {
		return TODO;
	}
	public Result save() {
		return TODO;
	}
}
