package DTO_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductModel {
	
	private Connection connection;
	
	public ProductModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<ProductDTO> getproducts() {	
		List<ProductDTO> products = new ArrayList<>();
		String query = "SELECT *FROM products";
		
		try {
			PreparedStatement st  = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				
				ProductDTO product = new ProductDTO();
				product.setProductId(result.getInt("product_id"));
				product.setProductName(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getInt("price"));
				product.setStockquantity(result.getInt("stock_quantity"));
				products.add(product);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products;
	
	}
	
}
