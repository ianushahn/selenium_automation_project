package scripts.homepage_scripts.functional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import generic.AllVerifications;
import generic.OpenClose;

public class ClicKEachCategoryOneByOne extends OpenClose
{
	public static void main(String[] args) throws InterruptedException {
		openApplication();

	     List<WebElement> allCategories = driver.findElements(By.cssSelector("div#categoryCarousel>div"));
	     int allCategoriesCount = allCategories.size();

	     for (int i = 1; i <= allCategoriesCount; i++)
	     {
	         WebElement eachCategory = driver.findElement(By.cssSelector("div#categoryCarousel>div:nth-of-type(" + i + ")>div"));

	         // Scroll into view
	         new Actions(driver).scrollToElement(eachCategory).build().perform();

	         String categoryName = eachCategory.getText().trim();
	         System.out.println("Clicking on : " + categoryName);

	         // Click the category
	         AllVerifications.clickIfVisibleAndEnabled(eachCategory, driver);
	         Thread.sleep(1000);
	         System.out.println(driver.getTitle());
	         System.out.println(driver.getCurrentUrl());
	         Thread.sleep(1000);

	         // 1) Preferred: header exactly equals category name (case-insensitive)
	         boolean textVerified = AllVerifications.textIsPresentOrNotIgnoreCase( categoryName,  driver, By.cssSelector("h1.text-3xl"));

	         // 2) Fallbacks: some UIs render Results/Result for "Category"
	         if (!textVerified) {
	             String resultsFor = "Results for \"" + categoryName + "\"";
	             String resultFor  = "Result for \""  + categoryName + "\"";

	             textVerified = AllVerifications.textIsPresentOrNotIgnoreCase(resultsFor, driver, By.cssSelector("h1.text-3xl"))
	                  || AllVerifications.textIsPresentOrNotIgnoreCase(resultFor,  driver, By.cssSelector("h1.text-3xl"));
	         }

	         if (!textVerified) {  System.out.println("Header mismatch for category: " + categoryName); }

	         driver.navigate().back();
	         Thread.sleep(1000);
	     }

	     System.out.println("Total Categories found: " + allCategoriesCount);
	     closeApplication();
	}
}
