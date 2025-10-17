package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenClose implements AutomationConstants
{
	public static WebDriver driver = null;
	
	   public static void openApplication()
	   {
		   driver = new ChromeDriver(); 
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		   driver.get(URL_HOME);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   }
	   
	   public static void closeApplication() throws InterruptedException
	   {
		  Thread.sleep(3000);
		  driver.quit();   
	   }
}
