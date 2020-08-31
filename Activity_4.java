package OrangeHRMProject;

import org.testng.annotations.Test;
import junit.framework.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_4 {
	
	WebDriver driver;
	
	@Test
  public void logIn() {
		//Open the OrangeHRM page and login with credentials provided
		driver = new FirefoxDriver();
		
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		String Title = driver.getTitle();
		
		System.out.println("The Title of the page is:" + Title);
		
		Assert.assertEquals("OrangeHRM", Title);
		
		System.out.println("Title matches with the Page Title");
		
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
		
		//Find the PIM option in the menu and click it.		
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click the Add button to add a new Employee.
		driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Fill in the required fields and click Save.
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		
		firstName.sendKeys("Monica");
		lastName.sendKeys("Rawat");
		
		driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
		
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement Status = driver.findElement(By.xpath("//select[@id='status']"));
		
		UserName.sendKeys("Monica Rawat");
		Status.sendKeys("Enabled");
				
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//String AdminPage = driver.findElement(By.xpath("//*[@id= 'menu_pim_viewEmployeeList']")).getText();
		
		//Navigate back to the Admin page and verify the creation of your employee.
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		
		System.out.println("Navigated back to Admin Page!!");	
		
		WebElement SearchUserName = driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']"));
		//WebElement SearchEmpName = driver.findElement(By.xpath("//input[@id='searchSystemUser_employeeName_empName']"));
		
		SearchUserName.sendKeys("Monica Rawat");
				
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		
		WebElement verify = driver.findElement(By.linkText("Monica Rawat"));
		Assert.assertEquals(verify.getText(), "Monica Rawat");
		
		System.out.println("Activity 4 completed successfully!!");
		
		//Close the browser.
		driver.close();
		
  }
  

  

}
