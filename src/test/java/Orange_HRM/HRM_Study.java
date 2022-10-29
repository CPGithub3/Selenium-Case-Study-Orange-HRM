package Orange_HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM_Study {
	public static String hrm = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	@BeforeTest
	public void BT()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(hrm);
	}
	
	@Test
	public void hrmcase() throws InterruptedException 
	{
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
		//get size
		List<WebElement> totallink = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links: " + totallink.size());
		
		//Click on Check Box
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(6).click();
		
		//Click on Delete Icon
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(6).click();
		
		//Click on Yes
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		
		//Logout Dropdown
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		
		//Click on Logout
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
		
		driver.quit();
	}

}
