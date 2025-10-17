package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_6334_click_on_product_from_exploreproductsFromPopularBrands_FromHomepage2 implements AutmationConstants {

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
		// click on categories from explore products from popular brand section 
		WebElement chargingFans  = driver.findElement(By.xpath("(//div[@class='min-w-[220px] border p-3 rounded shadow hover:shadow-md bg-white flex-shrink-0 cursor-pointer text-center'])[1]"));
		Thread.sleep(4000);
		chargingFans  .click();
		
		Thread.sleep(4000);
		System.out.println("fetcing title after clicking on   chargingFans");
		
		
		String actual_singleproduct_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_singleproduct_page_title_afterclick);
		
		
		String expectedsingleProductpageTitle = ExcelData.getData("singleproduct", 0, 0);
		
		
		if(expectedsingleProductpageTitle.equals(actual_singleproduct_page_title_afterclick  ))
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