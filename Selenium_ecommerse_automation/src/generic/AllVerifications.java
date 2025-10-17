package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllVerifications 
{
	public static boolean verifyTitle(String expectedTitle, WebDriver driver)
	{
		boolean titleVerified = false;
		
		WebDriverWait wait = new WebDriverWait( driver,Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			if(driver.getTitle().equals(expectedTitle))
			{
				titleVerified =true;
				System.out.println("Title verification passed , expected title was : "+expectedTitle +" , Title found : "+ driver.getTitle());
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Title verification failed ,expected title was : "+expectedTitle +" , Title found :  "+ driver.getTitle());
			TakingScrenshot.captureScreenshot(driver);
		}
		return titleVerified;
	}
	
	
	public static boolean verifyUrl(String expectedUrl, WebDriver driver)
	{
		boolean urlVerified = false;
		
		WebDriverWait wait = new WebDriverWait( driver,Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.urlMatches(expectedUrl));
			if(driver.getCurrentUrl().equals(expectedUrl))
			{
				urlVerified =true;
				System.out.println("Url verification passed , expected url was : "+expectedUrl +" , Url found : "+ driver.getCurrentUrl());
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Url verification failed , expected url was : "+expectedUrl +" , Url found : "+ driver.getCurrentUrl());
			TakingScrenshot.captureScreenshot(driver);
		}
		return urlVerified;
	}
	
	
	
	public static boolean textIsPresentOrNot(String expectedText, WebDriver driver, WebElement element)
	{
		boolean textVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			 wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			System.out.println("Text verification passed , expected text was : "+expectedText +" , Actal text found : "+ element.getText());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Text verification failed , expected text was : "+expectedText +" , Actal text found : "+ element.getText());
			TakingScrenshot.captureScreenshot(driver);
			
		}
		return textVerified; 
	}
	
	
	
	 public static boolean textIsPresentOrNotIgnoreCase(String expectedText, WebDriver driver, By locator) 
	    {
	        boolean textVerified = false; 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        try 
	        {
	            // Wait for *any* text to be present in the element (not case-sensitive)
	            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, expectedText)));
// textToBe -->is an inbuilt function which donot take document,instead it will take the locator of that element
	            String actualText = driver.findElement(locator).getText().trim();

	            if (actualText.equalsIgnoreCase(expectedText.trim())) 
	            {
	                System.out.println("Text verification passed. Expected: " + expectedText + " , Actual: " + actualText);
	                textVerified = true;
	            } 
	            else 
	            {
	                System.out.println("Text verification failed. Expected: " + expectedText + " , Actual: " + actualText);
	                TakingScrenshot.captureScreenshot(driver);
	            }
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	            System.out.println("Text verification failed (exception). Expected: " + expectedText + " , Actual: " + driver.findElement(locator).getText());
	            TakingScrenshot.captureScreenshot(driver);
	        }

	        return textVerified;
	    }


	
	
	
	
//	public static boolean clickIfVisibleAndEnabled(WebElement element, WebDriver driver)
//	{
//		boolean clicked = false;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		
//		
//		try
//		{
//			wait.until(ExpectedConditions.visibilityOf(element));
//			// check if its present and enabled. 
//			wait.until(ExpectedConditions.presenceOfElementLocated(null));  // elemt is present and enabled
//			
//			wait.until(ExpectedConditions.elementToBeClickable(element));
//			
//			clicked= true; 
//			System.out.println("Element clicked : "+ element);
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			System.out.println("Unable to click on the element : "+ element);
//			TakingScrenshot.captureScreenshot(driver);
//			
//		}
//		
//		return clicked; 
//	}
	
	
	
	public static boolean clickIfVisibleAndEnabled(WebElement element, WebDriver driver) {
        boolean clicked = false;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Check if element is present in DOM by catching StaleElementReferenceException
            if (element != null) {

                // Wait until visible
                wait.until(ExpectedConditions.visibilityOf(element));

                // Check if element is displayed and enabled
                if (element.isDisplayed() && element.isEnabled()) {

                    // Wait until element is clickable
                    wait.until(ExpectedConditions.elementToBeClickable(element));

                    // Perform click
                    element.click();
                    clicked = true;
                    System.out.println("Element clicked: " + element);
                } else {
                    System.out.println("Element is not displayed or not enabled: " + element);
                }

            } else {
                System.out.println("Element is null. Possibly not found in DOM.");
            }

        } catch (Exception ex) {
            System.out.println("Unable to click on the element: " + element);
            ex.printStackTrace();
            TakingScrenshot.captureScreenshot(driver);
        }

        return clicked;
    }
	
	
	
	public static boolean verifyTotalNumberOfElements(int expectedCount, WebDriver driver, By allButtons)
	{
		boolean countVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			 wait.until(ExpectedConditions.numberOfElementsToBe(allButtons,  expectedCount));
			 int actualCount = driver.findElements(allButtons).size();
			System.out.println("Count matching TC passed , expected count was : "+expectedCount +" , Actal Count found : "+ actualCount);
			countVerified = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			int actualCount = driver.findElements(allButtons).size();
			System.out.println("Count Not matching TC failed, expected count was : "+expectedCount +" , Actal Count found : "+ actualCount);
			TakingScrenshot.captureScreenshot(driver);
			
		}
		return countVerified; 
	}
	
	
}
