package SeleniumTraining.MorningBatch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exceptions 
{
	
	//Section 7.13: Selenium Exceptions - ExceptionHandling
	ChromeDriver driver = new ChromeDriver();
	@Test()
	public void ExceptionHandling() throws IOException, AWTException
	{
		String mobNumber = "1234567890";
		String fname = "Pankaj";
		String course = "CBSE Board";
		String subCourse = "8 Std";
		String group = "Group - B";
		
		driver.get("http://localhost:90/GBS_2024%20Build/Login.aspx");
    	driver.manage().window().maximize();
    	
    	//initialization();	
    	
    	driver.findElement(By.cssSelector("input.form-control")).sendKeys("#99");
    	driver.findElement(By.cssSelector("#txtPassword")).sendKeys("99");
    	driver.findElement(By.cssSelector("input[value='Login']")).click();
    	
 
    	driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();
    	
    	 // Opening the Enquiry page
    	 driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();

    	 driver.findElement(By.cssSelector("#ContentPlaceHolder1_txtMobileNo")).sendKeys(mobNumber);
    	 driver.findElement(By.cssSelector("#ContentPlaceHolder1_txtFirstName")).sendKeys(fname);

    	 //Clicking on Course, subcourse, groups, and Subjects
    	 driver.findElement(By.xpath("//table[@id='ContentPlaceHolder1_rdoListCourse']//label[text()='" + course + "']")).click();
    	 driver.findElement(By.xpath("//table[@id='ContentPlaceHolder1_rdoSubCourseList']//label[text()='" + subCourse + "']")).click();
    	 driver.findElement(By.xpath("//table[@id='ContentPlaceHolder1_rdoGroupList']//label[text()='" + group + "']")).click();
    	 driver.findElement(By.xpath("//label[text()='All Group']")).click();
    	
    	 
    	 driver.findElement(By.cssSelector("#ContentPlaceHolder1_btn_EnquirySave")).click();
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	
    	/*
    	
    	// 1. NoSuchElementException
    	
    	 try {
    		 WebElement group = driver.findElement(By.cssSelector("input#ContentPlaceHolder1_rdoGroupList_0"));    	
    		 group.click();
    	 	}
    	 catch(NoSuchElementException e)
    	 {
    		 System.out.println("1. Element not found!");
    	 }  
    	
    	 //2. TimeoutException 
    	 try {
     		// WebElement group = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
     	 	}
     	 catch(TimeoutException e)
     	 {
     		 System.out.println("2. This is TimeOut Exception!");
     	 }  
    	
    	 //3. ElementNotInteractableException
    	 try {
    		    WebElement button = driver.findElement(By.id("ContentPlaceHolder1_btnSendOTP"));
    		    button.click();
    		} catch (ElementNotInteractableException e) {
    		    System.out.println("3. Element is not interactable!");
    		}
   	 
    		 
    	 //4. NoSuchFrameException
    	 try {
    		    driver.switchTo().frame("nonExistentFrame");
    		} catch (NoSuchFrameException e) {
    		    System.out.println("4. Frame not found!");
    		}
    	
    	 //5. NoAlertPresentException
    	 try {
    		    Alert alert = driver.switchTo().alert();
    		} catch (NoAlertPresentException e) {
    		    System.out.println("5. No alert present!");
    		}
    	
    	 //6. InvalidElementStateException
    	 try {
    		    WebElement inputField = driver.findElement(By.cssSelector("input#ContentPlaceHolder1_btnSendOTP"));
    		    inputField.click();
    		} catch (InvalidElementStateException e) {
    		    System.out.println("6. Cannot interact with the element. It's in an invalid state.");
    		}


    	 //7. InvalidSelectorException
    	 try {
    		    WebElement element = driver.findElement(By.xpath("//*[@id='incorrect]"));
    		} catch (InvalidSelectorException e) {
    		    System.out.println("7. Invalid selector used!");
    		}
*/
    
       //driver.close();
	}	

}
