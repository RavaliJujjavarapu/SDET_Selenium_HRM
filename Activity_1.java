package OrangeHRMProject;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity_1 {
	
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		
		//Open a browser.Navigate to ‘http://alchemy.hguy.co/orangehrm’.

		driver.get("http://alchemy.hguy.co/orangehrm");
			
	  }
	
	@Test
  public void readTitleAndVerifyText() {
        //Get the title of the website.
		String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		//Make sure it matches “OrangeHRM” exactly.
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Title matches with the Page Title");
		
		
  }
  

  @AfterClass
  public void afterClass() {
	  //If it matches, close the browser.
	  driver.close();
  }

}
