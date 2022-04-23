package com.vandvtechsolution.inetbanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.vandvtechsolution.inetbanking.PageObjects.HomePage;
import com.vandvtechsolution.inetbanking.PageObjects.LoginPage;
import com.vandvtechsolution.inetbanking.TestBase.Testbase;

public class HomeTC001 extends Testbase {

	HomePage homepage;

	@Test(priority = 1)
	public void loginTC() {

		LoginPage Login = new LoginPage(driver);
		Login.setUsername(configer.getusername());
		Login.setPassword(configer.getpassword());
		homepage = Login.clickonloginbtn();
	}

	@Test(priority = 2)
	public void NavigateToNewCustomerPage() {
		homepage.clickon_newcustomer_link();
	}

	@Test(priority = 4)
	public void NavigateToLogoutPage() {
		homepage.clickon_logout_link();
		if (driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3, enabled = false)
	public void NavigateToDeleteCustomerPage() {
		homepage.clickon_deletecustomer_link();
	}
}
