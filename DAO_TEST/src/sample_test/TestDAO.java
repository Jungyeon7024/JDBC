package sample_test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	private Connection connection;
	
	public TestDAO(Connection connection) {
		this.connection = connection;
	}
	public boolean createTest(TestVO Test) {
		String sql = "INSERT INTO TestINFO (Test_id, Testname, email, reg_date)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, Test.getTestId());
			st.setString(2, Test.getTestName());
			st.setString(3, Test.getEmail());
			st.setDate(4,new Date(Test.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<TestVO> getAllTests() throws SQLException {
		List<TestVO> Tests = new ArrayList<>();
		String sql = "SELECT * FROM TestINFO";
		// try - with - resources
		// 데이터베이스 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			ResultSet rs = st.executeQuery();
			//selectOne-If selectAll-while
			while(rs.next()) {
				TestVO Test = new TestVO();
				Test.setTestId(rs.getInt("Test_id"));
				Test.setTestName(rs.getString("Testname"));
				Test.setEmail(rs.getString("email"));
				Test.setRegDate(rs.getDate("reg_date"));
				Tests.add(Test);
			}
		} 
		return Tests;
		}
}