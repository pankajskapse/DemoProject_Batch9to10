package SeleniumTraining.MorningBatch;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringOprations 
{

    @Test
    public void ApplicationLogin() 
    {
    	ChromeDriver driver = new ChromeDriver();
    	driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
    	driver.manage().window().maximize();
    	
    	
    	String loginPageTitle = "Login8";
    	String loginURL = "http://localhost:90/GBS_2024%20Build/Login5.aspx";
    	
    	if(loginPageTitle.contentEquals(driver.getTitle()))
    	{
    		System.out.println("My page Title is as expected");
    	}
    	else
    	{
    		System.out.println("My page Title is not correct");
    	}
    	if(loginURL.contentEquals(driver.getCurrentUrl()))
    	{
    		System.out.println("My page URL is as expected");
    	}
    	else
    	{
    		System.out.println("My page Title is not correct");
    	}
    	
    	driver.findElement(By.cssSelector("input.form-control")).sendKeys("#99");
    	driver.findElement(By.cssSelector("#txtPassword")).sendKeys("99");
    	driver.findElement(By.cssSelector("input[value='Login']")).click();
    	
    	
    	
    	
    	driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();
    	
    	driver.findElement(By.cssSelector("input#ContentPlaceHolder1_btn_EnquirySave")).click();
    	
    	WebElement message = driver.findElement(By.cssSelector("span#ContentPlaceHolder1_lab_message"));
    	
    	String displayedMessage = message.getText();
    	
    	System.out.println(displayedMessage);
    	
    //	driver.findElement(By.cssSelector("input[id='ContentPlaceHolder1_txtMobileNo']")).sendKeys("9561076629");
    	//driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtFirstName']")).sendKeys("TheD Infotech");
    }
}
