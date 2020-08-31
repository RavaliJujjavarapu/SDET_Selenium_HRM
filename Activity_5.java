package OrangeHRMProject;

import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity_5 {
	
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
				
		WebDriverWait wait = new WebDriverWait (driver, 20);
		
		//Open the OrangeHRM page and login with credentials provided
		WebElement userName = driver.findElement(By.xpath("//input[@id= 'txtUsername']"));
		WebElement passWord = driver.findElement(By.xpath("//input[@id ='txtPassword']"));
		
		userName.sendKeys("orange");
		passWord.sendKeys("orangepassword123");
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Find the “My Info” menu item and click it.
		
		WebElement MyInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
		wait.until(ExpectedConditions.elementToBeClickable(MyInfoTab));
		MyInfoTab.click();
				
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//On the new page, click the Edit button.
		
		WebElement EditButton = driver.findElement(By.xpath("//input[@id='btnSave']"));
		wait.until(ExpectedConditions.elementToBeClickable(EditButton));
		EditButton.click();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Fill in the Name, Gender, Nationality, and the DOB fields.
		
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("Monica");
		
		driver.findElement(By.xpath("//input[@id='personal_txtEmpMiddleName']")).clear();
		
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys("Rawat");
		
		//Gender
		
		driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Nationality
		//WebElement Nationality = driver.findElement(By.xpath("//input[@id='personal_cmbNation']"));
		Select selectNationality = new Select(driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]")));
		selectNationality.selectByVisibleText("Indian");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[3]/li[4]/img")).click();
				
		WebElement month = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
		
		Select selectDOM = new Select(month);
		
		selectDOM.selectByVisibleText("Mar");
		
		WebElement year = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
		
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[3]/td[1]/a")).click();
			
		//Click Save.
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser.
	  driver.close();
  }

}
