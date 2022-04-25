package com.vandvtechsolution.inetbanking.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public static String getCurrent_Date_Time(){
		SimpleDateFormat customdate = new SimpleDateFormat("dd/MM/yyyy_HH/mm/ss");
		Date currentdate = new Date();
		return customdate.format(currentdate);
	}
	public static String CaptureScreenShot(WebDriver driver) {
		String Screenshotpath= System.getProperty("user.dir")+"/Screenshots/inetbanking_"+getCurrent_Date_Time()+".png";
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(Screenshotpath));
			
			System.out.println("Screenshot captured");
					return Screenshotpath;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Screenshot not captured");
			return null;
		}
	}
}
