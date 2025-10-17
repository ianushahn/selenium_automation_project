package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import generic.AutmationConstants;
import generic.ExcelData;

public class S_2156_open_signin_page_clickon_Avatar_FromHomepage implements AutmationConstants {

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
		// click on Avatar tab from the header. 
		WebElement AvatarTab = driver.findElement(By.cssSelector("div.bg-gradient-to-r"));
		Thread.sleep(4000);
		AvatarTab.click();
		
		Thread.sleep(2000);
		System.out.println("fetching title after clicking on Avatar tab");
		
		
		String actual_Signin_page_title_afterclick = driver.getTitle(); 
		
		System.out.println(actual_Signin_page_title_afterclick);
		
		
		String expectedSignInPageTitle = ExcelData.getData("Signin avatar", 0, 0);
		
		
		if(expectedSignInPageTitle.equals(actual_Signin_page_title_afterclick ))
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