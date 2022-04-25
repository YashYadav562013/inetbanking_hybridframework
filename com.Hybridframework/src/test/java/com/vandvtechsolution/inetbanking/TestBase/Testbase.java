package com.vandvtechsolution.inetbanking.TestBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vandvtechsolution.inetbanking.Utility.ConfigDataProvider;
import com.vandvtechsolution.inetbanking.Utility.ExcelDataProvider;
import com.vandvtechsolution.inetbanking.Utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	static String Configdatapath = "./config/config.properties";
	static String excelDataProvider = "./TestData/Data.xlsx";

	public ConfigDataProvider configer;
	public ExcelDataProvider exceldata;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentreports;
	public ExtentTest extenttest;

	@BeforeSuite
	public void init() {
		configer = new ConfigDataProvider(Configdatapath);
		exceldata = new ExcelDataProvider(excelDataProvider);

		String extentreportpath = System.getProperty("user.dir") + "/reports/inetbanking_"
				+ Helper.getCurrent_Date_Time() + ".html";
		htmlReporter = new ExtentHtmlReporter(extentreportpath);
		htmlReporter.config().setDocumentTitle("Automation Test Reports");
		htmlReporter.config().setReportName("Functional Test Reports");
		htmlReporter.config().setTheme(Theme.DARK);

		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlReporter);
		extentreports.setSystemInfo("Hostname", "Local Host");
		extentreports.setSystemInfo("OS", "Windows 10");
		extentreports.setSystemInfo("Browser", "Chrome");
		extentreports.setSystemInfo("Environment", "Regression");
		extentreports.setSystemInfo("Tester Name", "Yash Yadav");
	}

	public WebDriver driver;

	@BeforeMethod
	@Parameters({ "Chrome" })
	public void Setup(@Optional("Chrome") String brname) {

		if (brname.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brname.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (brname.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser not matched with respected browser");
		}
		driver.manage().window().maximize();
		driver.get(configer.getURL());
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest.fail("Test case Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "Test case Skipped");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "Test case Passed");
		}

	}

	@AfterTest
	public void flushreports() {
		extentreports.flush();
		driver.quit();
	}
}
