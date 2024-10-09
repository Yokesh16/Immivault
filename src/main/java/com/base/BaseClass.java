package com.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	public static Properties properties;
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;

	@BeforeSuite
	public void name() {
		TestNG testNG = new TestNG();
		testNG.setUseDefaultListeners(true);
	}

	@BeforeTest
	public void setExtent() {

		File reportFile = new File(System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "ExtentReport" + File.separatorChar + "Immivault.html");
		System.out.println("Report Path: " + reportFile);

		if (reportFile.exists()) {
			reportFile.delete();
		}

		sparkReporter = new ExtentSparkReporter(reportFile);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extentReports.setSystemInfo("Project Name", properties.getProperty("project"));
		extentReports.setSystemInfo("URL", properties.getProperty("url"));
		sparkReporter.config().setDocumentTitle("Automation Report of Immivault");
		sparkReporter.config().setReportName("Automation Tests Results");

	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void browserLunch(ITestResult result, Method methodName) {

		String browser = properties.getProperty("browser").toLowerCase();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			setDriver(new FirefoxDriver());
			break;
		case "edge":
			setDriver(new EdgeDriver());
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name: " + browser);
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);
		getDriver().get(properties.getProperty("url"));

		
		/*
		 * getDriver().findElement(By.id("exampleInputEmail1")).sendKeys(properties.
		 * getProperty("username")); //
		 * getDriver().findElement(By.id("exampleInputPassword1")).sendKeys(properties.
		 * getProperty("password")); //
		 * getDriver().findElement(By.id("button_submit")).click();
		 */
		 
		test = extentReports.createTest(result.getMethod().getDescription().toString(),
				result.getMethod().getMethodName());
	}

	@AfterMethod
	public void browserClose(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		} else if (result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE) {

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}

		if (getDriver() != null) {
			
			
			/*
			 * WebElement logoutButton = driver.findElement(By.id("logoutButton"));
			 * logoutButton.click(); WebElement yes =
			 * driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
			 * yes.click();
			 */
			 
			// driver.quit();
		}
	}

	@AfterTest
	public void endReport() {

		extentReports.flush();

	}

	public BaseClass() {

		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + File.separator + "Configuration"
					+ File.separator + "Config.properties");
			properties = new Properties();

			properties.load(reader);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}

}
