package OrangeHRMProject;

import org.testng.annotations.Test;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity_8 {
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
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//Find the “My Info” menu item and click it.
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Navigate to the Dashboard page and click on the Apply Leave option.
		WebElement Dashboard = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]"));
		Dashboard.click();
		
		WebElement ApplyLeave = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img"));
		ApplyLeave.click();
		
		Select leaveType = new Select(driver.findElement(By.xpath("//*[@id=\"applyleave_txtLeaveType\"]")));
		leaveType.selectByVisibleText("Paid Leave");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[3]/img")).click();
		
		WebElement FromMonth = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
		
		Select selectMonth = new Select(FromMonth);
		
		selectMonth.selectByVisibleText("May");
		
		WebElement FromYear = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
		
		Select selectYear = new Select(FromYear);
		selectYear.selectByVisibleText("2020");
		
		//Select From Day
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[4]/td[5]/a")).click();
		
		//Scroll the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//ToSelection
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[4]/img"));
		
		//Scroll the page
		js.executeScript("window.scrollBy(0,600)");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement ToMonth = driver.findElement(By.xpath("//select[contains(@class,'month')]"));
		
		Select LeaveToMonth = new Select(ToMonth);
				
		LeaveToMonth.selectByVisibleText("May");
		
		WebElement ToYear = driver.findElement(By.xpath("//select[contains(@class,'year')]"));
		
		Select LeaveToYear = new Select(ToYear);
		LeaveToYear.selectByVisibleText("2020");
		
		js.executeScript("window.scrollBy(0,600)");
		
		//Select To Day
		driver.findElement(By.xpath("//a[contains(@class,'default')]")).click();
		
		js.executeScript("window.scrollBy(0,600)");
		
		//Click on Apply
		driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
		
		System.out.println("Test Passed");
				
  }
  

  @AfterClass
  public void afterClass() {
	  //Close the browser.
	  driver.close();
  }

}

