package com.kh.VODAOuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbusername = "khCafe";
		String dbpassword = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			System.out.println("아이디를 입력해주세요");
			String userName = sc.next();
			
			System.out.println("회원가입이 거의 다 끝났습니다");
			System.out.println("마지막으로 이메일 작성해주세요");
			String email = sc.next()	;
			
			Date regDate = new Date(); // 현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 정보 저장하기 
			
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email); 
			newUser.setRegDate(regDate);
			
			if(userDao.createUser(newUser)) {
				System.out.println("희원가입 완료");
			} else {
				System.out.println("회원 가입 실패");
			}
			
			connection.close();
			
			//데이터가 정상적으로 들어갔는지 boolean을 사용해서 확인
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
