package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class AppUtils 
{

	
	public static WebDriver driver;
	public static String url = "http://orangehrm.qedgetech.com";
	

	@BeforeSuite
	public static void launchApp()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");		
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);		
	}	
	
	@AfterSuite
	public static void closeApp()
	{
		driver.close();
	}
	
	
}
