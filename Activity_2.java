package OrangeHRMProject;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity_2 {
	
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		
		////Open a browser.Navigate to ‘http://alchemy.hguy.co/orangehrm’.
		driver.get("http://alchemy.hguy.co/orangehrm");
			
	  }
	
	@Test
  public void getTheURL() {
        String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Title matches with the Page Title");
		
		//Get the url of the header image.
		
		String headerURL = driver.findElement(By.xpath("//img[contains(@src,'/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png')]")).getAttribute("src");
		
		//Print the url to the console.
		System.out.println("URL of the header is:" +headerURL);
		
		System.out.println("Activity 2 completed successfully!!");
		
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser.
	  driver.close();
  }

}
