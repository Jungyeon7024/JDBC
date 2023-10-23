package sample_test;

import java.util.Date;

public class TestVO {

	
		private int testId;
		private String testName;
		private String email;
		private Date regDate;
		public int getTestId() {
			return testId;
		}
		public void setTestId(int testId) {
			this.testId = testId;
		}
		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName) {
			this.testName = testName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getRegDate() {
			return regDate;
		}
		public void setRegDate(Date regDate) {
			this.regDate = regDate;
		}
}
