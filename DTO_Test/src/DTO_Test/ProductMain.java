package DTO_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khCafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			ProductView view = new ProductView();
			
			ProductController controller = new ProductController(con, view);
			
			controller.displayALLProducts();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
