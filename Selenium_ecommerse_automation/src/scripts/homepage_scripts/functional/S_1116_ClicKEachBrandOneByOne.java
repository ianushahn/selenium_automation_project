package scripts.homepage_scripts.functional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import generic.AllVerifications;
import generic.OpenClose;

public class S_1116_ClicKEachBrandOneByOne  extends OpenClose
{
	 public static void main(String[] args) throws InterruptedException 
	    {
	        openApplication();

	        List<WebElement> allBrands = driver.findElements(By.cssSelector("div.grid:last-child>div"));
	        int allBrandCount = allBrands.size();

	        for (int i = 1; i <= allBrandCount; i++)
	        {
	            WebElement eachBrand = driver.findElement(By.cssSelector("div.grid:last-child>div:nth-of-type("+i+")>span"));

	            // Scroll into view
	            new Actions(driver).scrollToElement(eachBrand).build().perform();
	             String expectedbrandNameHomepage = eachBrand.getText().trim();
	            
	            System.out.println("Clicking on : " + expectedbrandNameHomepage);

	            // Click the category
	            AllVerifications.clickIfVisibleAndEnabled(eachBrand, driver);
	            Thread.sleep(1000);
	            System.out.println(driver.getTitle());
	            System.out.println(driver.getCurrentUrl());
	            Thread.sleep(1000);
	            
	            JavascriptExecutor js = (JavascriptExecutor)driver; 
	            Thread.sleep(1000);
	            js.executeScript("window.scrollTo(0,0);");
	            Thread.sleep(1000);
	            
	            WebElement expectedBrandNameSearhPage = driver.findElement(By.cssSelector("h1.text-3xl"));
	            String expectedBrandNameSearhPageText = expectedBrandNameSearhPage.getText();
	            AllVerifications.textIsPresentOrNot(expectedBrandNameSearhPageText, driver, expectedBrandNameSearhPage);

	            driver.navigate().back();
	            Thread.sleep(1000);
	        }
	        
	        System.out.println("Total Brands found: " + allBrandCount);
	        
	        driver.navigate().to(URL_HOME);
	        closeApplication();
	    }
}
