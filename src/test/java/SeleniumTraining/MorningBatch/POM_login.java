package SeleniumTraining.MorningBatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.login;
import utils.Base;

public class POM_login extends Base
{		
	
	@BeforeMethod()
	public void setUP()
	{
		InitApp();
		login ln = new login();
		Assert.assertTrue(ln.verifyPageTitle());
		ln.loginWithValidCredentials("#99", "99");	
	}
	
	@AfterMethod()
	public void closeDriver()
	{
		driver.close();	
	}
	
	@Test()
	public void openEnquiryPage()
	{
		driver.findElement(By.xpath("//a/span[text()='Enquiry']")).click();
	}
	
	@Test()
	public void openEnquiryListPage()
	{
		driver.findElement(By.xpath("//a/span[text()='Enquiry List']")).click();
	}
	
	@Test()
	public void openFollowUpPage()
	{
		driver.findElement(By.xpath("//a/span[text()='Follow Up']")).click();
	}
	
	/**
	 *  @BeforeSuite
		@BeforeTest
		@BeforeClass
		//@BeforeMethod
		//@Test
		//@AfterMethod
		@AfterClass
		@AfterTest
	 */
	
}
