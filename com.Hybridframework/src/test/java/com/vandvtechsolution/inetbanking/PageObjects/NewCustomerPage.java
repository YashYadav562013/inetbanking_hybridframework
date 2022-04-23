package com.vandvtechsolution.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "name")
	WebElement CustumernameTxt;
	@FindBy(xpath = "//input[@name='rad1' and @value='m']")
	WebElement MaleRadioBtn;
	@FindBy(xpath = "//input[@name='rad1' and @value='f']")
	WebElement FemaleRadioBtn;
	@FindBy(name = "dob")
	WebElement DateOfBirth;
	@FindBy(name = "addr")
	WebElement AddressTxt;
	@FindBy(name = "city")
	WebElement CityTxt;
	@FindBy(name = "state")
	WebElement StateTxt;
	@FindBy(name = "pinno")
	WebElement PincodeTxt;
	@FindBy(name = "telephoneno")
	WebElement MobileNumTxt;
	@FindBy(name = "emailid")
	WebElement EmailIDTxt;
	@FindBy(name = "password")
	WebElement PasswordTxt;
	@FindBy(name = "sub")
	WebElement SubmitBtn;

	public void SetCustomername(String Custumername) {
		CustumernameTxt.clear();
		CustumernameTxt.sendKeys(Custumername);

	}

	public void ClickonGenderRadioBtn(String Gender) {
		if (Gender.equals("Male")) {
			MaleRadioBtn.click();
		} else {
			FemaleRadioBtn.click();
		}
	}

	public void SetDateOfBirth(String DOB) {
		DateOfBirth.sendKeys(DOB);
		DateOfBirth.sendKeys(DOB);
		DateOfBirth.sendKeys(DOB);
	}

	public void SetAddress(String address) {
		AddressTxt.clear();
		AddressTxt.sendKeys(address);
	}

	public void SetCityName(String cityname) {
		CityTxt.clear();
		CityTxt.sendKeys(cityname);
	}

	public void SetStateName(String statename) {
		StateTxt.clear();
		StateTxt.sendKeys(statename);
	}

	public void SetPincode(String pincode) {
		PincodeTxt.clear();
		PincodeTxt.sendKeys(pincode);
	}

	public void SetMobileNumber(String number) {
		MobileNumTxt.clear();
		MobileNumTxt.sendKeys(number);
	}

	public void SetEmail_ID(String emailID) {
		EmailIDTxt.clear();
		EmailIDTxt.sendKeys(emailID);
	}

	public void SetPassword(String password) {
		PasswordTxt.clear();
		PasswordTxt.sendKeys(password);
	}

	public void ClickonSubmitBtn() {
		SubmitBtn.click();
	}
}
