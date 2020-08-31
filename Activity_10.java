package OrangeHRMProject;

import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Activity_10 {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Title matches with the Page Title");
			
	  }
	
	@Test
  public void LogIn() {
				
		//WebDriverWait wait = new WebDriverWait (driver, 20);
		
		//Open the OrangeHRM page and login with credentials provided
		WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));
		
		userName.sendKeys("orange");
		passWord.sendKeys("orangepassword123");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		//Navigate to the “Recruitment” page.
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]")).click();
		
		//Click on the “Vacancies” menu item to navigate to the vacancies page.
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewJobVacancy\"]")).click();
		
		//Scroll the page
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,600)");
		
		//Click on the “Add” button to navigate to the “Add Job Vacancy” form.
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		
		//Fill out the necessary details.
		
		Select JobTitle = new Select(driver.findElement(By.xpath("//*[@id=\"addJobVacancy_jobTitle\"]")));
				
		JobTitle.selectByIndex(2);
		
		WebElement HiringManager = driver.findElement(By.xpath("//*[@id=\"addJobVacancy_hiringManager\"]"));
		HiringManager.sendKeys("Test Test");
		
		WebElement VacancyName = driver.findElement(By.xpath("//*[@id=\"addJobVacancy_name\"]"));
		VacancyName.sendKeys("Test Ltd");
		
		js.executeScript("window.scrollBy(0,600)");
		
		//Click the “Save” button to save the vacancy.
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		
		//Verify that the vacancy was created.
		WebElement verify = driver.findElement(By.linkText("Test Ltd"));
		Assert.assertEquals(verify.getText(), "Test Ltd");
		
		System.out.println("Activity 10 completed successfully!!");
				
				
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser.
	  driver.close();
  }

}

