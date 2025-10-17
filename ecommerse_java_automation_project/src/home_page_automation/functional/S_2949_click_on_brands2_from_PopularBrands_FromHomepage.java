package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_2949_click_on_brands2_from_PopularBrands_FromHomepage implements AutmationConstants {

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
		// click on brands  from popular brand section 
		WebElement leftarrow = driver.findElement(By.cssSelector("button.absolute.-left-4"));
		Thread.sleep(4000);
	leftarrow .click();
		
		Thread.sleep(4000);
		System.out.println("fetcing title after clicking on  leftarrow");
		
		
		String actual_Home_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_Home_page_title_afterclick);
		
		
		String expectedhometpageTitle = ExcelData.getData("Homepage", 0, 0);
		
		
		if(expectedhometpageTitle.equals(actual_Home_page_title_afterclick  ))
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