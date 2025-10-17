package home_page_automation.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerification;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_8967_open_homepage_using_url implements AutmationConstants {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver(); 		
		driver.get(urlOfApplication);
		
		String expectedHomepageTitle = ExcelData.getData("Homepage", 0, 0);
		
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		
		String expectedHomepageUrl = ExcelData.getData("Homepage", 0, 1);
		AllVerification.verifyUrl(expectedHomepageUrl, driver);
		
		
		Thread.sleep(5000);
		driver.quit();
	}
}