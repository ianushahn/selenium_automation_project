package generic;

import java.io.File;

public interface AutomationConstants 
{
//  String rootFolder = System.getProperty("user.dir");
//  String excelSheetPath   = rootFolder + File.separator + "project_documents.xlsx";
//  String failedScreenshots = rootFolder + File.separator + "failedScreenshots";
//  String urlOfApplication  = "http://localhost:5173";
//  String url2OfApplication = "http://localhost:5173/";
//  String url3OfApplication = "http://localhost:5173/home";

		//  // first mention what or where is the rootDirectory of the project. 
		String rootDirectory = System.getProperty("user.dir");
	//	
//		// mention where is the excel sheet present. 
		String excelSheetPath = rootDirectory+ File.separator +"project_documents.xlsx";
	//	
//		// mention failed screenshot folder path. 
		String failedScreenshots = rootDirectory + File.separator +"failedScreenshots";
	    
		 String URL_OF_APPLICATION = "http://localhost:5173";
	    // ========= Common / Public =========
	    String PATH_HOME                = "/";
	    String PATH_HOME_ALIAS1         = "/home";
	    String PATH_HOME_ALIAS2         = "/homepage";
	    String PATH_CONTACT_US          = "/contact-us";
	    String PATH_ABOUT_US            = "/about-us";
	    String PATH_LOGIN               = "/login";
	    String PATH_REGISTER            = "/register";
	    String PATH_PAGE_NOT_FOUND      = "/page-not-found";

	    String URL_HOME                 = URL_OF_APPLICATION + PATH_HOME;  // localhost:5173/
	    String URL_HOME_ALIAS1          = URL_OF_APPLICATION + PATH_HOME_ALIAS1;  // localhost:5173/home
	    String URL_HOME_ALIAS2          = URL_OF_APPLICATION + PATH_HOME_ALIAS2;
	    String URL_CONTACT_US           = URL_OF_APPLICATION + PATH_CONTACT_US;
	    String URL_ABOUT_US             = URL_OF_APPLICATION + PATH_ABOUT_US;
	    String URL_LOGIN                = URL_OF_APPLICATION + PATH_LOGIN;
	    String URL_REGISTER             = URL_OF_APPLICATION + PATH_REGISTER;
	    String URL_PAGE_NOT_FOUND       = URL_OF_APPLICATION + PATH_PAGE_NOT_FOUND;
	    
	    String PATH_SHOP                = "/shop";
	    String URL_SHOP                 = URL_OF_APPLICATION + PATH_SHOP; 

	}

