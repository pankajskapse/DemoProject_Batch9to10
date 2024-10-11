package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
	public static WebDriver driver;
	
	public static void initialization() 
	{
		driver = new ChromeDriver();
		driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void clickByJavaScript(WebElement element) // Method added by Pankaj Kapse
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0].click();", element);
	}
/*
 * public static void initialization() 
	{
		String browserName = prop.getProperty("browser");
		  if (browserName.equals("Chrome")) {
			  
			  System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\01Drivers\\chromedriver-win64_128\\chromedriver.exe");
			  //driver= new ChromeDriver();
			  
//			  ChromeOptions chromeOptions = new ChromeOptions();
//			  chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
//			  driver = new ChromeDriver(chromeOptions);
//			  
			  ChromeOptions chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--remote-allow-origins=*");
			 // chromeOptions.addArguments("user-data-dir=C:/path/to/your/custom/profile");
			  driver = new ChromeDriver(chromeOptions);
			  
			    
		  } 
		  else if (browserName.equals("FireFox")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\TestAutomation\\01Drivers\\geckodriver.exe");
			  driver = new FirefoxDriver();
		  }
		  else  if (browserName.equals("IE")) {
			  System.setProperty("webdriver.ie.driver", "C:\\TestAutomation\\01Drivers\\IEDriverServer.exe");
			  driver= new InternetExplorerDriver();
		  }
		 driver.manage().window().maximize();		  
	     driver.manage().deleteAllCookies();
		  
		  Action.implicitWait(driver, 20);
		  Action.pageLoadTimeOut(driver, 15);
		  driver.get(prop.getProperty("url"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;  
		  js.executeScript("localStorage.setItem(arguments[0],arguments[1])", "[49]lastVisitedProjectPage", "/projects/101");
		
	}
 * */

}
