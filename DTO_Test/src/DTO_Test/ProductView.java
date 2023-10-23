package DTO_Test;

import java.util.List;

public class ProductView {
	
	public void displayProducts(List<ProductDTO>products) {
		for(ProductDTO  p  : products) {
			System.out.println("Product_Id : "+p.getProductId());
			System.out.println("Product_name : "+ p.getProductName());
			System.out.println("Category : "+ p.getCategory());
			System.out.println("Price : "+ p.getPrice());
			System.out.println("Stock_quantity : "+p.getStockquantity());
			System.out.println();
			
		}
	}
}
