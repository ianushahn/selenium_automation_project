package scripts.homepage_scripts.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerification;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_6026_open_homepage_clickonlogo implements AutmationConstants{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver(); 	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String expectedHomepageTitle = ExcelData.getData("Homepage", 0, 0);
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click on logo from the header. 
		WebElement logo = driver.findElement(By.cssSelector("div.flex.items-center.gap-6>a:first-child"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logo.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("fetcing title after clicking on logo");
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}
}
