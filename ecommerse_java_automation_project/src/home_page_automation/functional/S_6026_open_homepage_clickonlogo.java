package home_page_automation.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerification;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_6026_open_homepage_clickonlogo implements AutmationConstants {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver(); 		
		driver.get(urlOfApplication);
		
		String expectedHomepageTitle = ExcelData.getData("Homepage", 0, 0);
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		
		Thread.sleep(2000);
		// click on logo from the header. 
		WebElement logo = driver.findElement(By.cssSelector("div.flex.items-center.gap-6>a:first-child"));
		Thread.sleep(2000);
		logo.click();
		
		Thread.sleep(2000);
		System.out.println("fetcing title after clicking on logo");
		
		
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		
		Thread.sleep(5000);
		driver.quit();
	}
}