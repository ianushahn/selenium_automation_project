package generic;

public interface AutmationConstants 
{
  String urlOfApplication = "http://localhost:5173";
  
  String rootDirectory = System.getProperty("user.dir");   //root location of the project
  
  String excelSheetLocation = rootDirectory+"\\projectDocuments.xlsx";


  
  String failedScreenshots = rootDirectory +"\\failedScreenshots";
}
