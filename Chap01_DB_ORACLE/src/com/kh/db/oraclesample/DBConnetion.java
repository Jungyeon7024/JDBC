package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnetion {
		public static void main(String[] args) {
				selectIf();
		}

static void selectIf() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용하여 조건추가
			String selectQuery = "SELECT * FROM BANK WHERE account_number=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"1234567890", "5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			
			//여기에 원하는 조건의 account_id 설정
			//int targetID = 1;
			
			//조건 설정
			//selectState.setInt(1, targetID);
			
			ResultSet result = selectState.executeQuery();
			
			
			
			if (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				
				System.out.println("ACCOUNT_ID : " + a);
				System.out.println("ACCOUNT_NUMBER : " + b);
				System.out.println("ACCOUNT_NAME : " + c);
				System.out.println("BALANCE: " + d);
				System.out.println("BRANCH_NAME: " + e);
				System.out.println("LAST_TRANSACTION_DATE : " + f);
			} else {
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


static void insertBank() {

	String user = "khbank";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String password = "kh1234";
	//where절 사용하여 조건추가
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"+ 
									"VALUES (?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 14);
			insertState.setString(2, "16533219");
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5,  "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate()	;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
}

static void insertKhcafe() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	Connection con = null;
	try {
		con = DriverManager.getConnection(url, user, password);
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}}



}
