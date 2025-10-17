package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AllVerifications 
{
	WebDriver driver = null;
	
	protected AllVerifications(WebDriver driver)
	{
		this.driver = driver;
	}

	public static boolean verifyTitle(String expectedTitle, WebDriver driver, SoftAssert sa)
	{
		boolean isTitleVerified = false; 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			isTitleVerified = true;
			System.out.println("Title Vefication successfull, expected title : "+ expectedTitle + " Actual title : "+ driver.getTitle());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Title Vefication failed, expected title : "+ expectedTitle + " Actual title : "+ driver.getTitle());
			TakingScreenshot.captureScreenshot(driver);
		}
		return isTitleVerified; 
	}
	
	
	
	
	public static boolean verifyUrl(String expectedUrl, WebDriver driver , SoftAssert sa)
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
			TakingScreenshot.captureScreenshot(driver);
		}
		return urlVerified;
	}
	
	
	
	public static boolean textIsPresentOrNot(String expectedText, WebDriver driver, WebElement element , SoftAssert sa)
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
			TakingScreenshot.captureScreenshot(driver);
			
		}
		return textVerified; 
	}
	
	
	
	 public static boolean textIsPresentOrNotIgnoreCase(String expectedText, WebDriver driver, By locator , SoftAssert sa) 
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
	                TakingScreenshot.captureScreenshot(driver);
	            }
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	            System.out.println("Text verification failed (exception). Expected: " + expectedText + " , Actual: " + driver.findElement(locator).getText());
	            TakingScreenshot.captureScreenshot(driver);
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
	
	
	
	public static boolean clickIfVisibleAndEnabled(WebElement element, WebDriver driver , SoftAssert sa) 
	{
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
            TakingScreenshot.captureScreenshot(driver);
        }

        return clicked;
    }
	
	
	
	public static boolean verifyTotalNumberOfElements(int expectedCount, WebDriver driver, By allButtons , SoftAssert sa)
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
			TakingScreenshot.captureScreenshot(driver);
			
		}
		return countVerified; 
	}
	
	
	
	
	
	
}
