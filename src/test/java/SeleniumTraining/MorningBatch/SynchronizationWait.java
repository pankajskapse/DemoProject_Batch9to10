package SeleniumTraining.MorningBatch;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SynchronizationWait //extends utils.TestBase
{
	ChromeDriver driver = new ChromeDriver();
	
	 //Section 7.15: Synchronization in Selenium
	@Test()
	public void waitMechanism()
	{
		waitExplicate();
    	driver.close();
	}
	
		public void waitImplicit() //Implicit Wait
		{		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
	    	driver.manage().window().maximize();
	    	
	    	driver.findElement(By.cssSelector("input.form-control")).sendKeys("#99");
	    	driver.findElement(By.cssSelector("#txtPassword")).sendKeys("99");
	    	driver.findElement(By.cssSelector("input[value='Login']")).click();
	    	
	    	
	    	driver.findElement(By.id("ContentPlaceHolder1_txtFirstName")).click();
	    	//driver.quit();
	    	
		}		
		
		public void waitExplicate() //Explicit Wait
		{
			driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
	    	driver.manage().window().maximize();
	    	
	    	driver.findElement(By.cssSelector("input.form-control")).sendKeys("#99");
	    	driver.findElement(By.cssSelector("#txtPassword")).sendKeys("99");
	    	driver.findElement(By.cssSelector("input[value='Login']")).click();
	    		 
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	    	
	    	driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();
	    	
	    	
	    	
	    	//1. visibilityOfElementLocated - Waits until the element is visible on the webpage.
	    	try 
	    	{
	    		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ContentPlaceHolder1_rdoGroupList_0")));
	    		System.out.println("Group is displayed now!");
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	    	
	    	driver.findElement(By.xpath("//a/span[text()='Course']")).click();
	    	// 2. elementToBeClickable - Waits until the element is clickable.
	    	try 
	    	{
	    		//WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("ContentPlaceHolder1_btnEdit")));
	    		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("ContentPlaceHolder1_btnEdit")));
	    		button.click();
	    		System.out.println("Clicked on the element");
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    	
	    	// 3. textToBePresentInElement - Waits for specific text to be present in the element.
	    	try
	    	{
	    		WebElement textBox = driver.findElement(By.id("ContentPlaceHolder1_Lab_message"));
	    				wait.until(ExpectedConditions.textToBePresentInElement(textBox,"Course updated successfully."));
	    				System.out.println("Message verified!");
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	    
		}
}


