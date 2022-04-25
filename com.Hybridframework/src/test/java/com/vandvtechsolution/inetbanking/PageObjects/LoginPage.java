package com.vandvtechsolution.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vandvtechsolution.inetbanking.Utility.Helper;

public class LoginPage {

	// Object Repository
	// this is loginpage Repository
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Login page repository

	@FindBy(name = "uid")
	WebElement txt_username;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(name = "btnLogin")
	WebElement loginbtn;

	// now we can perform the action
	public void setUsername(String username) {
		try {
			txt_username.clear();
			txt_username.sendKeys(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPassword(String password) {
		try {
			txt_password.clear();
			txt_password.sendKeys(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HomePage clickonloginbtn() {
		try {
			loginbtn.click();
			
			if (driver.getTitle().equals("Guru99 Bank Manager HomePage1001")) {
				Helper.CaptureScreenShot(driver);
				Assert.assertTrue(true);
				return new HomePage(driver);
			} else {
				Helper.CaptureScreenShot(driver);
				if(Helper.isAlertPresent(driver)) {
				//driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
				}
				Assert.assertFalse(false);
				Helper.CaptureScreenShot(driver);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
