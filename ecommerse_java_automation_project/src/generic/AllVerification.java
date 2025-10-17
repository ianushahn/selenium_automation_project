package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerification 
{
	
	public static boolean verifyTitle(String expectedTitle, WebDriver driver)
	{
		boolean titleVerified = false; 
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
//		waiting for duration of 20 sec in order to fetch title is known as pooling time
		
		try
		{
			// here is where we will try to match the title with expected title
//			String actualTitle = driver.getTitle(); 
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			if(driver.getTitle(). equals(expectedTitle))
			{
				titleVerified = true;
				System.out.println("Title verification passed, exptected was : " + expectedTitle +" found : " + driver.getTitle());
			}
//			if(titleVerified == true)
//			{
//				
//			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			// if title did not match take screenshot here.
			System.out.println("Title verification failed, exptected was : " + expectedTitle +" found : " + driver.getTitle());
			TakingScreenshot.captureScreenshot(driver);
		}
	
		return titleVerified;
	}
	
	
	
	// funtion to verify the url of the page. 
	public static boolean verifyUrl(String expectedUrl, WebDriver driver)
	{
		boolean urlVerified = false; 
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			// here is where we will try to match the title with expected title
			String actualUrl = driver.getCurrentUrl(); 
			wait.until(ExpectedConditions.urlMatches(expectedUrl));
			if(actualUrl.equals(expectedUrl))
			{
				urlVerified = true;
			}
			if(urlVerified == true)
			{
				System.out.println("Url verification passed, exptected was : " + expectedUrl +" found : " + driver.getCurrentUrl());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			// if title did not match take screenshot here.
			System.out.println("Url verification failed, exptected was : " + expectedUrl +" found : " + driver.getCurrentUrl());
		}
	
		return urlVerified;
	}
	
	

}