package OrangeHRMProject;

import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Activity_11 {
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
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Navigate to the “Recruitment” page.
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]")).click();
		
		//Scroll the page
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				//js.executeScript("window.scrollBy(0,600)");
		
		//click on the Add button to add candidate information.
		driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
		
		//On the next page, fill in the details of the candidate.
		
		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"addCandidate_firstName\"]"));
		WebElement LastName = driver.findElement(By.xpath("//*[@id=\"addCandidate_lastName\"]"));
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"addCandidate_email\"]"));
		
		FirstName.sendKeys("Monica");
		LastName.sendKeys("Rawat");
		Email.sendKeys("Monica@test.com");
		
		//Upload a resume (docx or pdf) to the form.
		File file = new File("C:\\Users\\MonicaRawat\\UploadResume.docx");
		
		WebElement AddResume = driver.findElement(By.xpath("//*[@id=\"addCandidate_resume\"]"));
		
		AddResume.sendKeys(file.getAbsolutePath());
		
		//Scroll the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//Click Save.
		
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		
		//Navigate back to the Recruitments page to confirm candidate entry.
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]")).click();
		
		driver.findElement(By.xpath("//input[@id = 'candidateSearch_candidateName']")).sendKeys("Monica Rawat");
		driver.findElement(By.xpath("//input[@id = 'btnSrch']")).click();
		
		WebElement verify = driver.findElement(By.linkText("Monica Rawat"));
		Assert.assertEquals(verify.getText(), "Monica Rawat");
		
				
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser.
	  driver.close();
  }

}

