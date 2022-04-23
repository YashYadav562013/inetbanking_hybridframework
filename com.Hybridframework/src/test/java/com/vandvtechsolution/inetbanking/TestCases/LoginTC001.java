package com.vandvtechsolution.inetbanking.TestCases;

import org.testng.annotations.Test;

import com.vandvtechsolution.inetbanking.PageObjects.LoginPage;
import com.vandvtechsolution.inetbanking.TestBase.Testbase;

public class LoginTC001 extends Testbase {

	@Test
	public void loginTC() {

		LoginPage Login = new LoginPage(driver);
		Login.setUsername(configer.getusername());
		Login.setPassword(configer.getpassword());
		Login.clickonloginbtn();
	}
}
