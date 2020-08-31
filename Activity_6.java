package OrangeHRMProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity_6 {
	WebDriver driver;

	@Test(priority = 0)
	public void login() {
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).click();
	}

	@Test(priority = 1)
	public void directory() {
		WebDriverWait wait = new WebDriverWait(driver , 20);
		WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul"));
		WebElement directory = menu.findElement(By.partialLinkText("Directory"));
		//System.out.println("Directory is displayed " + directory.isDisplayed());
		if(directory.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]")));
			directory.click();
			//System.out.println("Directory is clicked ");
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1"), "Search Directory"));
			WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1"));
			//System.out.println(text.getText());
			Assert.assertEquals(text.getText(), "Search Directory");
		}
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
