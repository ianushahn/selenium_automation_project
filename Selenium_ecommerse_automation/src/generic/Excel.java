package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel implements AutomationConstants
{
	public static String getData(String sheetName, int rowNumber, int cellNumber) {
        String value = "";
        FileInputStream fis = null;
        Workbook wb = null;

        try {
            // Find the file location
            File file = new File(excelSheetPath);

            // Open the file
            fis = new FileInputStream(file);

            // Create Workbook instance
            wb = WorkbookFactory.create(fis);

            // Get the required cell
            Cell cell = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber);

            if (cell == null) {
                return "NULL"; // Cell is missing entirely
            }

            // Handle based on cell type
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;

                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        value = cell.getDateCellValue().toString(); // or format as needed
                    } else {
                        value = String.valueOf(cell.getNumericCellValue());
                    }
                    break;

                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;

                case FORMULA:
                    // Get the formula result type
                    switch (cell.getCachedFormulaResultType()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            value = "Unsupported formula result type";
                    }
                    break;

                case BLANK:
                    value = "BLANK";
                    break;

                case ERROR:
                    value = "ERROR: " + cell.getErrorCellValue();
                    break;

                default:
                    value = "Unknown Cell Type";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Ensure resources are closed
            try {
                if (wb != null) {
                    wb.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return value;
    }
}


