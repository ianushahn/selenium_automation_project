package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class TakingScreenshot implements AutmationConstants 
{


public static void captureScreenshot(WebDriver driver)
 {
	 try
	 {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ramLocation =ts.getScreenshotAs(OutputType.FILE);
		
		Date d =new Date();
		String sdf =new SimpleDateFormat("ddmmyyyy_HHmmss").format(d);
		
		File hardDiskLocation = new File(failedScreenshots+ "\\image_"+sdf+" .jpg");
		Files.copy(ramLocation,hardDiskLocation);
		
		System.out.println("Screen shot taken successfully.");
		
	 }
	 catch(Exception ex)
	 
	 {
	   ex.printStackTrace();
	   System.out.println("Something went wrong unable take screenshot.");
	 }
 }
 
}
