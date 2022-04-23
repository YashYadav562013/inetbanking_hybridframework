package com.vandvtechsolution.inetbanking.Utility;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static boolean isAlertPresent(WebDriver driver) {
		
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public String SetRandomValue() {
		return RandomStringUtils.randomAlphanumeric(6);
		
	}
}
