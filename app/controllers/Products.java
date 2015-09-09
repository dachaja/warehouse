package controllers;

import java.util.Formatter;
import java.util.Set;

import models.Product;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Products extends Controller{
	private static final Form<Product> productForm = Form.form(Product.class);
	
	public Result list() {
		Set<Product> products = Product.findAll();
		return ok(list.render(products));
	}
	public Result showBlank() {
		return ok(show.render(productForm));
	}
	public Result show(Long ean) {
		final Product product = Product.findByEan(ean);
		StringBuilder sb = new StringBuilder();
		Formatter fm = new Formatter(sb);
		if(product == null) {
			fm.format("Product %s does not exist.", ean);
			return notFound(sb.toString());
		}
		
		Form<Product> filledForm = productForm.fill(product);
		return ok(show.render(filledForm));
	}
	public Result save() {
		Form<Product> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()) {
			flash("error", "Please correct the form below.");
			return badRequest(show.render(boundForm));
		}
		
		Product product = boundForm.get();
		Product.add(product);
		flash("success", String.format("Successfully added product %s", product));
		
		return redirect(routes.Products.list());
	}
}
