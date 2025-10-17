package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_7459_open_shopall_page_clickonShopalllink_FromHomepage implements AutmationConstants {

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
		// click on shopall link from the header. 
		WebElement shopAllLink = driver.findElement(By.cssSelector("div.flex.items-center.gap-6>a:last-child"));
		Thread.sleep(2000);
		shopAllLink.click();
		
		Thread.sleep(2000);
		System.out.println("fetcing title after clicking on Shop all link");
		
		
		String actual_shopall_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_shopall_page_title_afterclick);
		
		
		String expectedShopallpageTitle = ExcelData.getData("Shopallpage", 0, 0);
		
		
		if(expectedShopallpageTitle.equals(actual_shopall_page_title_afterclick ))
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