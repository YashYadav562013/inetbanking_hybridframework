package com.vandvtechsolution.inetbanking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.vandvtechsolution.inetbanking.PageObjects.HomePage;
import com.vandvtechsolution.inetbanking.PageObjects.LoginPage;
import com.vandvtechsolution.inetbanking.PageObjects.NewCustomerPage;
import com.vandvtechsolution.inetbanking.TestBase.Testbase;
import com.vandvtechsolution.inetbanking.Utility.Helper;

public class NewCustumerTC001 extends Testbase {
	@Test
	public void loginTC() throws InterruptedException {
		LoginPage Login = new LoginPage(driver);
		Login.setUsername(configer.getusername());
		Login.setPassword(configer.getpassword());
		HomePage HomePage = Login.clickonloginbtn();
		Thread.sleep(3000);
		NewCustomerPage addnewcustomer = HomePage.clickon_newcustomer_link();
		driver.navigate().refresh();
		HomePage.clickon_newcustomer_link();
		addnewcustomer.SetCustomername("Yash Yadav");
		addnewcustomer.ClickonGenderRadioBtn("Male");
		addnewcustomer.SetAddress("GrandeView7 Society");
		addnewcustomer.SetDateOfBirth("25");
		addnewcustomer.SetDateOfBirth("12");
		addnewcustomer.SetDateOfBirth("1995");
		addnewcustomer.SetCityName("Pune");
		addnewcustomer.SetStateName("Maharashtra");
		addnewcustomer.SetPincode("411046");
		addnewcustomer.SetMobileNumber("8485842537");
		addnewcustomer.SetEmail_ID(new Helper().SetRandomValue()+"@gmil.com");
		addnewcustomer.SetPassword("Hodo@5613");
		addnewcustomer.ClickonSubmitBtn();
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}
}