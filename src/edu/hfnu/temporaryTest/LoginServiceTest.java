package edu.hfnu.temporaryTest;

import java.sql.SQLException;

import edu.hfnu.service.LoginService;

public class LoginServiceTest {
	private static LoginService login = new LoginService();
	public static void main(String[] args) throws SQLException {
		//testMethod1();
		//testMethod2();
	}
	private static void testMethod2() throws SQLException {
		String name = "shetuan1";
		String password = "shetuan1";
		String type="shetuan";
		boolean flag = login.validateByNameAndPwd(name, password, type);
		System.out.println(flag);
	}
	private static void testMethod1() throws SQLException {
		String name = "tuanwei1";
		String type = "tuanwei";
		boolean flag = login.isExistUser(name, type);
		System.out.println(flag);
	}

}
