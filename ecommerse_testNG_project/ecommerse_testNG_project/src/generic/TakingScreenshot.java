package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakingScreenshot extends OpenClose
{
	
  public static void captureScreenshot(WebDriver driver)
  {
	  try
	  {
		  TakesScreenshot ts = (TakesScreenshot) driver; 
		  File ramLocation = ts.getScreenshotAs(OutputType.FILE);
		  Date d =new Date();
		  
		  String currentDate = new SimpleDateFormat("ddmmYYYY_HHmmss").format(d);
		  
		  // location in your system to store the screenshot. with name of the image and type of the image (.png, .jpg, .jpeg etc) 
		  File hdLocation = new File(failedScreenshots+ File.separator+"image_"+currentDate+".png");
		  
		  FileHandler.copy(ramLocation, hdLocation);
		  
		  System.out.println("Screenshot Stored in : "+ failedScreenshots + "folder." );
	  }
	  catch(Exception ex)
	  {
		  ex.printStackTrace();
		  System.out.println("Unable to take the screenshot.");
	  }
  }
}
