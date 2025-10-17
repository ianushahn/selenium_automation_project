package home_page_automation.functional;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutmationConstants;
import generic.ExcelData;

public class S_6973_giving_emailInput_and_subcrbe_from_Homepage  implements AutmationConstants
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
		
		WebElement emailField= driver.findElement(By.cssSelector("form.flex>input.w-full"));
		Thread.sleep(1000);
		
		// enter pen as the text in the input field. 
		emailField.sendKeys("anusha@gmail.com");
		Thread.sleep(2000);
		
		WebElement subscribeButton = driver.findElement(By.cssSelector("button.w-full"));
		Thread.sleep(2000);
		
		subscribeButton.click();
		Thread.sleep(2000);
		
		
		try
		{
			//switch to alert. 
			Alert alert = driver.switchTo().alert();
			Thread.sleep(2000);
			// fetch the text in the alert. 
			String alertsText = alert.getText();
			Thread.sleep(1000);
			System.out.println(alertsText);
			Thread.sleep(1000);
			// close the alter window. 
			alert.accept();
			Thread.sleep(1000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		
		
		
		System.out.println("After handling alert , verify homepage title again.");
		
		// check if the user has navigated to search product page. 
		
		String homepageExpectedTitle = ExcelData.getData("Homepage", 0, 0);
		
	System.out.println("DAta fretched from excel. ");
		
       System.out.println(homepageExpectedTitle);
		
	String  actual_homepage_title_afterclick = driver.getTitle(); 
		
		
		 System.out.println(actual_homepage_title_afterclick);
		
		if(homepageExpectedTitle.equals(actual_homepage_title_afterclick))
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
