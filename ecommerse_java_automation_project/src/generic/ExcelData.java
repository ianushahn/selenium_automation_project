package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData implements AutmationConstants
{
	
	public static String getData(String sheetName, int rowNumber, int cellNumber)
	{
		String v = "";
		try
		{
//	        / we will try to fetch the data from excel sheet	
			File f  = new File(excelSheetLocation);   //1.create file using the location of that file
			FileInputStream fis = new FileInputStream(f);
//	FileInputStream is a inbuilt class used to get inside that file	
//			f is a reference variable knows about excel sheet location
			Workbook wb = WorkbookFactory.create(fis);
//	in order to get workbook we use 	WorkBookFactory	 and create fis 	
			v= wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
		return v; 
	}
}
