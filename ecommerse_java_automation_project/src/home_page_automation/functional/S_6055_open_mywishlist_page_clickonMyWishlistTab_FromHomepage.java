package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_6055_open_mywishlist_page_clickonMyWishlistTab_FromHomepage implements AutmationConstants {

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
		// click on MyWishList tab from the header. 
		WebElement myWishListTab = driver.findElement(By.cssSelector("div.hidden.items-center.gap-6>a:first-child"));
		Thread.sleep(4000);
		myWishListTab.click();
		
		Thread.sleep(2000);
		System.out.println("fetching title after clicking on MyWishList tab");
		
		
		String actual_MyWishList_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_MyWishList_page_title_afterclick);
		
		
		String expectedMyWishListTitle = ExcelData.getData("MyWishList page", 0, 0);
		
		
		if(expectedMyWishListTitle.equals(actual_MyWishList_page_title_afterclick ))
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