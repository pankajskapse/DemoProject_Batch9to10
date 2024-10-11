package SeleniumTraining.MorningBatch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class section_7_8_WindowHandling
{
	ChromeDriver driver = new ChromeDriver();
	@Test()
	public void WindowHandling() throws IOException
	{
		//loginIMS();
    	//driver.get("https://thedinfotech.wordpress.com/");
    	//driver.manage().window().maximize();
    	
    	//brokenLinksAutomate();   
		ShowNotifications();
       
	}	
	
	public void ShowNotifications()   //Section 7.14: Handling “Show Notifications” in Selenium
	{
		  // Create ChromeOptions to set preferences
        ChromeOptions options = new ChromeOptions();

        // Disable the "Show Notifications" pop-up
        options.addArguments("--disable-notifications");

        // Initialize ChromeDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
	}
	
	public void loginIMS()
	{
		String loginPageTitle = "Login";
		driver.get("http://localhost:90/GBS_2024%20Build/login.aspx");
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), loginPageTitle);
	
		driver.findElement(By.id("txtUserID")).sendKeys("#99");
		driver.findElement(By.id("txtPassword")).sendKeys("99");	
		
		
		try {
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		}
		catch(NoSuchElementException e)
		{
			 System.out.println("Element not found!");			 
		}
	}
	public void brokenLinksAutomate() //Section 7.11: How to Automation BrokenLinks
	{
		// Get all anchor tags (<a> elements) with href attributes
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        // Loop through all links and verify their status
        for (WebElement linkElement : links) 
        {
            String linkUrl = linkElement.getAttribute("href");
            
            // Check if the link is not null or empty
            if (linkUrl != null && !linkUrl.isEmpty()) {
                try {
                    // Call method to check if the link is broken
                    checkLinkStatus(linkUrl);
                } catch (IOException e) {
                	writeToFile("Error checking the link: " + linkUrl);
                   // System.out.println("Error checking the link: " + linkUrl);
                }
            }
        }

	}
	 // Method to check the HTTP status of the link 
	 //checkLinkStatus(String linkUrl) this method is a part of Section 7.11: How to Automation BrokenLinks
    public static void checkLinkStatus(String linkUrl) throws IOException {
        try {
            // Create a URL object
            URL url = new URL(linkUrl);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set a HEAD request (faster than GET for link status checking)
            connection.setRequestMethod("HEAD");
            
            // Establish the connection and get the response code
            connection.connect();
            int responseCode = connection.getResponseCode();
            
            // Check if the response code indicates a broken link
            if (responseCode >= 400) 
            {
            	writeToFile(linkUrl + " is a broken link. Response code: " + responseCode);
              // System.out.println(linkUrl + " is a broken link. Response code: " + responseCode);
            } else 
            {
            	writeToFile(linkUrl + " is valid. Response code: " + responseCode);
                //System.out.println(linkUrl + " is valid. Response code: " + responseCode);
            }
        } catch (Exception e) 
        {
        	writeToFile("Exception occurred for link: " + linkUrl + " -> " + e.getMessage());
            //System.out.println("Exception occurred for link: " + linkUrl + " -> " + e.getMessage());
        }
    }

    public static void writeToFile(String data) // Log write in to a text file
    {
        try (FileWriter writer = new FileWriter("C:\\Users\\Acer\\eclipse-workspace\\MorningBatch\\src\\test\\java\\TestData\\LogFiles\\broken_links_report.txt", true)) 
        {
            writer.write(data + "\n");
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

	public void windowHandling() throws IOException //Section 7.8: Window Handling in selenium
	{
		String mainWindowHandle = driver.getWindowHandle();    	
    	driver.findElement(By.xpath("//a[text()='Our Products']")).click();
    	
    	// Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) 
        {
        	driver.switchTo().window(windowHandle);
        	
            // Check if the window title matches the new window
        	 if (driver.getTitle().equals("Store – theD: Code, Create, Conquer")) 
             {
        		
                // Perform actions on the new window
                System.out.println("Title of the new window: " + driver.getTitle());  
                
              
                //Section 7.9: Scrolling web Page in Selenium                
                //1. Scrolling to a Specific Element
                WebElement element = driver.findElement(By.xpath("//a[text()='Download']")); 
                
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
              
               
                //2. Scrolling to the Bottom of the Page
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
             
                
                //3. Scrolling to the Top of the Page
                js.executeScript("window.scrollTo(0, 0)");
               
           
               // Section 7.10: How to take Screenshots in Selenium
                // 1. Capture screenshot and store it as a file
                File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                
                // Define the destination file path
                File destinationFile = new File("C:\\Users\\Acer\\eclipse-workspace\\MorningBatch\\src\\test\\java\\TestData\\RunTimeScreenshots\\StorePageScreenshot.png");
                
                // Save the screenshot to the desired location
                FileUtils.copyFile(screenshotFile, destinationFile);
                
               
             
                // 2. Capture screenshot of the specific element
                File elementScreenshot = element.getScreenshotAs(OutputType.FILE);

                // Save the screenshot
                FileUtils.copyFile(elementScreenshot, new File("C:\\Users\\Acer\\eclipse-workspace\\MorningBatch\\src\\test\\java\\TestData\\RunTimeScreenshots\\StorePageDownLoadBtnScreenshot.png"));
          
             }                     
        }
      //  driver.switchTo().window(mainWindowHandle);
        // Close the new window
     
        
     // Switch back to the main window
       driver.switchTo().window(mainWindowHandle);
	}
}
