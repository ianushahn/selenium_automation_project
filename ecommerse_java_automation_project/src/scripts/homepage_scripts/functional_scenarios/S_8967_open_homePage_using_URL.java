package scripts.homepage_scripts.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerification;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_8967_open_homePage_using_URL implements AutmationConstants
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver(); 	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		String expectedHomepageTitle = ExcelData.getData("Homepage", 0, 0);
		AllVerification.verifyTitle(expectedHomepageTitle, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String expectedHomepageUrl = ExcelData.getData("Homepage", 0, 1);
		AllVerification.verifyUrl(expectedHomepageUrl, driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.quit();
	}

}
