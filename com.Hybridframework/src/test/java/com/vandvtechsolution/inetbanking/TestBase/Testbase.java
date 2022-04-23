package com.vandvtechsolution.inetbanking.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.vandvtechsolution.inetbanking.Utility.ConfigDataProvider;
import com.vandvtechsolution.inetbanking.Utility.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	static String Configdatapath= "./config/config.properties";
	static String excelDataProvider="./TestData/Data.xlsx";
	
	public ConfigDataProvider configer;
	public ExcelDataProvider exceldata;
	
	@BeforeSuite
	public void init() {
	  configer=new ConfigDataProvider(Configdatapath);
	  exceldata = new ExcelDataProvider(excelDataProvider);
	}
	
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"Chrome"})
	public void Setup(@Optional("Chrome")String brname) {

		if (brname.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (brname.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		 else if (brname.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		else {
			System.out.println("Browser not matched with respected browser");
		}
		driver.manage().window().maximize();
		driver.get(configer.getURL());
	}
	
	@AfterMethod(enabled=false)
	public void teardown() throws InterruptedException {
		Thread.sleep(6000);
		driver.quit();
	}
}
