package DTO_Test;

import java.sql.Connection;
import java.util.List;

public class ProductController {

	private ProductModel model;
	private ProductView view;
	
	
	public ProductController(Connection con,ProductView view) {
		this.model = new ProductModel(con);
		this.view = view;
	}
	
	public void displayALLProducts() {
		List<ProductDTO>products = model.getproducts();
		view.displayProducts(products);
	}
	
}
