package SeleniumTraining.MorningBatch;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

/**
 * Unit test for simple App.
 */
public class Login extends utils.TestBase
{

    /**
     * Rigorous Test :-)
     * @throws AWTException 
     */
	
	
    @Test
    public void ApplicationLogin() throws AWTException  
    {
    	String FromCity = "Nagpur";
		String ToCity = "Mumbai";
		String FlightCompany = "IndiGo";
		String FlightNumber = "6E 6659";
		String tripType = "Multi City";
		
    	String DepDate = "21";
    	String DepMonth = "October";
    	String DepYear = "2024";    	
    	
     	
    	//ChromeDriver driver = new ChromeDriver();
    	
    	 System.setProperty("webdriver.gecko.driver", "C:\\TestAutomation\\01Drivers\\Firefox Drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
    	
    	driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		List<WebElement> tripTypeList = driver.findElements(By.cssSelector("ul.fswTabs li"));
		
		for(WebElement rt : tripTypeList)
		{
			if(tripType.equals(rt.getText()))
			{
				rt.click();
				if(rt.isEnabled())
					System.out.println(rt.getText() + " is Selected");
				else
					System.out.println(rt.getText() + " is Not Selected");
			}
		
				
		}
		
		/*	
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(FromCity);
		driver.findElement(By.xpath("//span[text()='"+ FromCity + "']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(ToCity);
		driver.findElement(By.xpath("//span[text()='" + ToCity + "']")).click();
		
		if(tripType.equals("Round Trip"))
		{
			driver.findElement(By.xpath("//div[text()='" + DepMonth + "']/../..//p[text()='21']")).click();
		} else
		{
			driver.findElement(By.xpath("//div[text()='" + DepMonth + " " + DepYear + "']/../..//p[text()='" +DepDate+ "']")).click();
		}
		*/
		
		//div[text()='October 2024']/../..//p[text()='21']
		
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_ESCAPE);
	
		
		// Selecting date from calendar
	//	driver.findElement(By.xpath("//div[text()='"+DepMonth+ " " + DepYear+ "']/../..//div[@class='DayPicker-Body']//p[text()='"+DepDate+"']")).click();
		
		
		// Select and click on "View Price" button
//		driver.findElement(By.xpath("//p[@data-cy='submit']/a[text()='Search']")).click();
				
//		driver.findElement(By.xpath("//div[@id='listing-id']//p[text()='"+FlightCompany+"' ]/../p[text()='"+FlightNumber+"']/../../../..//button")).click();
		    
		
    }
    public void DynamicDD() throws AWTException
    {
    	String FromCity = "Nagpur";
		String ToCity = "Pune";
		String FlightCompany = "IndiGo";
		String FlightNumber = "6E 6659";
		
		//Robot robot = new Robot();
		
		
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.cssSelector("#fromCity")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(FromCity);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//span[text()='"+FromCity+"']")).click();
		
		driver.findElement(By.cssSelector("#toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(ToCity);
		driver.findElement(By.xpath("//span[text()='"+ToCity+"']")).click();
    
		//robot.keyPress(KeyEvent.VK_ESCAPE);
		
		// Select and click on "View Price" button
		driver.findElement(By.xpath("//p[@data-cy='submit']/a[text()='Search']")).click();
		
		driver.findElement(By.xpath("//div[@id='listing-id']//p[text()='"+FlightCompany+"' ]/../p[text()='"+FlightNumber+"']/../../../..//button")).click();
    }
    public void misApplication()
    {
    	ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
		driver.manage().window().maximize();
    	
    	  	
    	//initialization();	
    	
    	driver.findElement(By.cssSelector("input.form-control")).sendKeys("#99");
    	driver.findElement(By.cssSelector("#txtPassword")).sendKeys("99");
    	driver.findElement(By.cssSelector("input[value='Login']")).click();
    	
 
    	driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();
    	
    	driver.findElement(By.cssSelector("input[id='ContentPlaceHolder1_txtMobileNo']")).sendKeys("9561076629");
    	driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtFirstName']")).sendKeys("TheD Infotech");
    	
    	
    	// Locate the dropdown element by ID
    	WebElement enquiryTypeWElement = driver.findElement(By.id("ContentPlaceHolder1_ddlEnquiryType"));
    	
    	// Create an instance of the Select class
    	Select enquiryTypeDD = new Select(enquiryTypeWElement);

    	// Select the option by visible text
    	enquiryTypeDD.selectByVisibleText("Others");
    	enquiryTypeDD.selectByIndex(2);
    	enquiryTypeDD.selectByValue("3");
    	
       	
    	WebElement femaleRb = driver.findElement(By.xpath("//input[@id='RadioButtonF']"));
    	if(!femaleRb.isSelected())
    		femaleRb.click();
        	
    	

    	

        assertTrue(true);
    }
   
    
}
