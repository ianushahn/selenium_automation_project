package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenClose  implements AutmationConstants
{
	public static WebDriver driver=null;
	
	public static void openApplication()
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get( urlOfApplication );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	public static void closeApplication()throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
