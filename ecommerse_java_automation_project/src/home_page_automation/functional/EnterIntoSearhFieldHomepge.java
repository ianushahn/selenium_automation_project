package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutmationConstants;
import generic.ExcelData;

public class EnterIntoSearhFieldHomepge  implements AutmationConstants
{

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
		
		
		
		// find the serch field. 
		
		WebElement searchField = driver.findElement(By.cssSelector("input.flex-grow"));
		Thread.sleep(1000);
		
		// enter pen as the text in the input field. 
		searchField.sendKeys("Pen");
		Thread.sleep(1000);
		
		WebElement searchButton = driver.findElement(By.cssSelector("button.px-4"));
		Thread.sleep(1000);
		
		searchButton.click();
		Thread.sleep(1000);
		
		
		// check if the user has navigated to search product page. 
		
		String searhProductExpectedTitle = ExcelData.getData("Searhproductpage", 0, 0);
		
		System.out.println("DAta fretched from excel. ");
		
        System.out.println(searhProductExpectedTitle);
		
		String  actualsearhProductExpectedTitle = driver.getTitle(); 
		
		
		 System.out.println(actualsearhProductExpectedTitle);
		
		if(searhProductExpectedTitle.equals(actualsearhProductExpectedTitle))
		{
			System.out.println("Test case pass, title is matching.");
		}
		else
		{
			System.out.println("Test case failed cos title didnt match.");
		}
		
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
