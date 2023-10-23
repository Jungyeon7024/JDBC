package sample_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		TestMain um = new TestMain();
		um.selectScanner();
	}
	//boolean idTrue = checkId(TestId);
	public boolean checkId(int testId) throws SQLException {
		//1. DB연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbtestName = "khcafe";
		String dbPassWord = "kh1234";
		Connection cc = DriverManager.getConnection(jdbcURL, dbtestName, dbPassWord);
		//2. SQL
		String sql = "Select * From testINFO where test_id = ?";
		
		PreparedStatement st = cc.prepareStatement(sql);
		st.setInt(1, testId);
		//3. IF활용해서 Result.next()
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			int id = rs.getInt(1);
			return id >0; //이상이면 true
		}
		//     return >0 1이상이면 일치
		
		return false; //일치하지 않을 때
	}
	public void selectScanner() {
		//1. DB 연결 URL, TestNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbTestName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
		Connection cc = DriverManager.getConnection(jdbcURL, dbTestName, dbPassWord);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Test ID 입력해주세요.");
			System.out.println("종료하고싶다면 특수문자 제외 [e] 입력");
			String input = sc.nextLine();
			
			//만약에 e를 입력했다면
			//if("e"==input || "E" == input) {
			if("e".equalsIgnoreCase(input)) {
				System.out.println("종료하겠습니다.");
				break; 
				//break가 없으면 종료되지 않음 종료하겠습니다 만 출력됨
			}
			
			int TestId = Integer.parseInt(input);
			String email = sc.nextLine();
			System.out.println("이메일을 입력해주세요. : ");
			String TestEmail = email;// sc활용
			//select 문 출력하기 
			String sql = "SELECT * FROM TestINFO WHERE Test_id = ? AND email = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, TestId);
			st.setString(2, TestEmail);
			ResultSet rs = st.executeQuery();
			
			//selectOne if
			if(rs.next()) {
				System.out.println("Test ID   : " + rs.getInt("Test_id"));
				System.out.println("TestName  : " + rs.getString("Testname"));
				System.out.println("E M A I L : " + rs.getString("email"));
				System.out.println("Registration Date : " + rs.getDate("reg_date"));
				System.out.println();
			} else {
				//boolean ID or Email 하나가 일치하지 않는 경우 처리
				boolean idTrue = checkId(TestId);
				boolean emailTrue = checkEmail(TestEmail);
				 if(!idTrue && emailTrue) {
					 System.out.println("일치하지 않는 Test ID 입니다.");
					 System.out.println();
				 } else if (idTrue && !emailTrue) {
					 System.out.println("일치하지 않는 Test Email 입니다.");
					 System.out.println();
				 } else {
						System.out.println("일치하는 Test Id와 email을 찾을 수 없습니다.");
						System.out.println();
				 }

			}
			
			
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	private boolean checkEmail(String testEmail) {
		// TODO Auto-generated method stub
		return false;
	}
	public void selectAll() {
		//1. DB 연결 URL, TestNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbTestName = "khcafe";
		String dbPassWord = "kh1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbTestName, dbPassWord);
			TestDAO TestDAO = new TestDAO(connection);
			
			List<TestVO> Tests = TestDAO.getAllTests();
			
			for(TestVO u : Tests) {
			System.out.println("Test ID : " + u.getTestId());
			System.out.println("Test Name : " + u.getTestName());
			System.out.println("Test Email : " + u.getEmail());
			System.out.println("Registration Date : "+u.getRegDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbTestName = "khcafe";
		String dbPassWord = "kh1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbTestName, dbPassWord);
			TestDAO TestDao = new TestDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Test ID : ");
			int TestId = sc.nextInt();
			
			System.out.println("아이디를 입력 해주세요 : ");
			String TestName = sc.next();
			
			System.out.println("회원가입이 거의다 끝났습니다.");
			System.out.println("마지막으로 이메일 작성해주세요. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			TestVO newTest = new TestVO();
			newTest.setTestId(TestId);
			newTest.setTestName(TestName);
			newTest.setEmail(email);
			newTest.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 확인 boolean을 사용해서 확인
			if(TestDao.createTest(newTest)) { //true
				System.out.println("유저가 성공적으로 등록되었습니다.");
			} else {						  //false
				System.out.println("유저 등록에 실패하였습니다.");
			}
			
			//연결 닫기
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}