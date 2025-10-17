package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenClose implements AutomationConstants
{
	public static WebDriver driver = null; 
	
	@BeforeMethod
	public static void openApplication()
	{
	    driver = new ChromeDriver(); 
	    driver.manage().window().maximize(); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(URL_HOME);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@AfterMethod
	public static void closeApplication()
	{
		driver.quit();
	}

}
