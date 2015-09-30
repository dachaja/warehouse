package controllers;

import java.util.Formatter;
import java.util.Set;

import models.Product_Static;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

public class Products extends Controller{
	private static final Form<Product_Static> productForm = Form.form(Product_Static.class);
	
	public Result list() {
		Set<Product_Static> products = Product_Static.findAll();
		return ok(list.render(products));
	}
	public Result showBlank() {
		return ok(show.render(productForm));
	}
	public Result show(Long ean) {
		final Product_Static product = Product_Static.findByEan(ean);
		if(product == null) {
			return notFound(String.format("Product %s does not exist.", ean));
		}
		
		Form<Product_Static> filledForm = productForm.fill(product);
		return ok(show.render(filledForm));
	}
	public Result save() {
		Form<Product_Static> boundForm = productForm.bindFromRequest();
		if(boundForm.hasErrors()) {
			flash("error", "Please correct the form below.");
			return badRequest(show.render(boundForm));
		}
		
		Product_Static product = boundForm.get();
		Product_Static.add(product);
		flash("success", String.format("Successfully added product %s", product));
		
		return redirect(routes.Products.list());
	}
}
