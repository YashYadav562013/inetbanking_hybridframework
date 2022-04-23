package com.vandvtechsolution.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vandvtechsolution.inetbanking.Utility.Helper;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// create object repository of home page functionality.

	@FindBy(linkText = "New Customer")
	WebElement newcustomer_link;

	@FindBy(linkText = "Edit Customer")
	WebElement editcustomer_link;

	@FindBy(linkText = "Delete Customer")
	WebElement deletecustomer_link;

	@FindBy(linkText = "New Account")
	WebElement newaccount_link;

	@FindBy(linkText = "Log out")
	WebElement logout_link;

	public NewCustomerPage clickon_newcustomer_link() {
		try {
			newcustomer_link.click();
			return new NewCustomerPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public EditCustomerPage clickon_editcustomer_link() {
		try {
			editcustomer_link.click();
			return new EditCustomerPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public DeleteCustomerPage clickon_deletecustomer_link() {
		try {
			deletecustomer_link.click();
			return new DeleteCustomerPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public NewAcountPage clickon_newaccount_link() {
		try {
			newaccount_link.click();
			return new NewAcountPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public LogoutPage clickon_logout_link() {
		try {
			logout_link.click();
			if(Helper.isAlertPresent(driver)) {
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
			}
			return new LogoutPage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
