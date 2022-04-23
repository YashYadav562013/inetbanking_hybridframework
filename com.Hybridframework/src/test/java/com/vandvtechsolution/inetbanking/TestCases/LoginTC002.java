package com.vandvtechsolution.inetbanking.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vandvtechsolution.inetbanking.PageObjects.LoginPage;
import com.vandvtechsolution.inetbanking.TestBase.Testbase;

public class LoginTC002 extends Testbase {
	/*
	 * @Test public void loginTC() {
	 * 
	 * LoginPage Login = new LoginPage(driver);
	 * Login.setUsername(exceldata.getStringCellValue("Sheet1", 1, 0));
	 * Login.setPassword(exceldata.getStringCellValue(0, 1, 1));
	 * Login.clickonloginbtn(); }
	 */
	@DataProvider
	public Object[][] getdata() {
		 return exceldata.getExcelTestdata("DDT_Login");
	}

	@Test(dataProvider = "getdata")
	public void LoginTC(Object username, Object password) {
		LoginPage Login = new LoginPage(driver);
		Login.setUsername((String) username);
		Login.setPassword((String) password);
		Login.clickonloginbtn();
	}
}
