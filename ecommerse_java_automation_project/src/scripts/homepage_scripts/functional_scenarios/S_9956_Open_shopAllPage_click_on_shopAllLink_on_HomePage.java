package scripts.homepage_scripts.functional_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AllVerification;
import generic.AutmationConstants;
import generic.ExcelData;
import generic.OpenClose;

public class S_9956_Open_shopAllPage_click_on_shopAllLink_on_HomePage extends OpenClose {



	public static void main(String[] args) throws InterruptedException {
		OpenClose.openApplication();
		
		String expectedhomepageTitle = ExcelData.getData("Homepage", 0, 0);
		AllVerification.verifyTitle(expectedhomepageTitle, driver);
//		
		
		// click on ShopNow button from the main image of hero section 
		Thread.sleep(2000);
		WebElement ShopNowbutton = driver.findElement(By.cssSelector("div.animate__fadeInUp>a.inline-block"));
		Thread.sleep(2000);
		ShopNowbutton.click();
		
		Thread.sleep(2000);
//		
		
		String expectedShopAllPageTitle = ExcelData.getData("Shopallpage", 0, 0);
		AllVerification.verifyTitle(expectedShopAllPageTitle, driver);
		
//		
		OpenClose.closeApplication();
	}

}
