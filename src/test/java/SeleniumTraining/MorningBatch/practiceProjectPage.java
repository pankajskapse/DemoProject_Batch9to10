package SeleniumTraining.MorningBatch;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practiceProjectPage  extends utils.TestBase
{
	@Test()
	public void practicePage()
	{
		
		/* Requirements 
		 * 1. Select a Instructor Name "Santosh Narayane"
		 * 2. Select a Topics "AI – ML" 
		 * 3. Select a Course "SDET/Test Architect Essentials -Road to Full stack QA"
		 * 4. CLick on "Submit" button
		 * 5. Verify the Success message and selections
		 * */
		//ChromeDriver driver = new ChromeDriver();
    	
		String RadioButtonV = "Radio4";
		String CheckboxV = "Checkbox 3";
		String Course = "Selenium Automation in simple Python Language with Live Projects";
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\01Drivers\\chromedriver-win64_128\\chromedriver.exe");
		  driver = new ChromeDriver();
   	
		  driver.manage().window().maximize();
		  driver.get("https://thedinfotech.wordpress.com/practice-project/");
		  
		  driver.findElement(By.xpath("//legend[text()='Radio Button Example']/../p/input[@value='"+RadioButtonV+"']")).click();
		  driver.findElement(By.xpath("//legend[text()='Checkbox Example']/..//label/span[text()='"+CheckboxV+"']")).click();
		  
		  WebElement courseDropDown = driver.findElement(By.cssSelector("#g248-coursedropdownexample"));
		  Select courseDropDownList = new Select(courseDropDown);
		  courseDropDownList.selectByVisibleText(Course);
		  
		  driver.findElement(By.xpath("//button[text()='Submit']")).click();
		  
		 // clickByJavaScript()
		  
		  
	}

}
