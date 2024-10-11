package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Base;

public class login extends Base
{
	
	String PageTitle="Login";
	String pageURL="http://localhost:90/GBS_2024%20Build/Login.aspx";
	
	@FindBy(xpath = "//input[@id='txtUserID']")
	WebElement userID;
	
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;
	
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginBtn;
	
	
	public login()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public WebElement getuserID()
	{
		return userID;
	}
	public WebElement getpassword() {return password;}
	public WebElement getloginBtn() { return loginBtn;}
	
	public void loginWithValidCredentials(String ui, String pw)
	{
		userID.sendKeys(ui);
		password.sendKeys(pw);
		loginBtn.click();
	}
	
	public void verifyURL()
	{
		
	}
	
	public boolean verifyPageTitle()
	{
		String actulTitle = driver.getTitle();
		if(PageTitle.contains(actulTitle))
		{
			return true;
		}
		return false;
	}
	

}
