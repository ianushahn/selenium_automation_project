package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_9805_open_CartSummary_page_clickonMiniCartTab_FromHomepage implements AutmationConstants {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver(); 		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		String expectedHomepageTitle = ExcelData.getData("Homepage", 0, 0);
		
		System.out.println("Expected title : " + expectedHomepageTitle);
		
		String actual_homepage_title = driver.getTitle(); 
		
		System.out.println("Actual title found : " + actual_homepage_title );
		
		
		if(expectedHomepageTitle.equals(actual_homepage_title ))
		{
			System.out.println("Successfully loaded homepage.");
		}
		else
		{
			System.out.println("Falied to load homepage");
		}
		
		Thread.sleep(2000);
		// click on MiniCart tab from the header. 
		WebElement MiniCartTab = driver.findElement(By.cssSelector("div.relative>button.relative"));
		Thread.sleep(4000);
		MiniCartTab.click();
		
		Thread.sleep(2000);
		System.out.println("fetching title after clicking on MiniCart tab");
		
		
		String actual_MiniCart_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_MiniCart_page_title_afterclick);
		
		
		String expectedMiniCartPageTitle = ExcelData.getData("CartSummary page", 0, 0);
		
		
		if(expectedMiniCartPageTitle.equals(actual_MiniCart_page_title_afterclick ))
		{
			System.out.println("Test case pass.");
		}
		else
		{
			System.out.println("Test case failed.");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}