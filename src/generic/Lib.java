package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class Lib implements IAutoConstant{
	
	public static Workbook wb;

	public static String getCellValue(String excelFileName, String sheetName, int rowNum, int colNum) {
	String cellValue = "";
	
	try {
		Workbook wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"));
		cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
	} catch (Exception e) {
		
	}
		
	
	return cellValue;
}
	
	public static int getTotalRowCount(String excelFileName, String sheetName) {
		int rowCount = 0;
		try {
		wb= WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"));
		rowCount = wb.getSheet(sheetName).getLastRowNum();
		}catch (Exception e) {
			
		}
		return rowCount;
	}
	
	public static String getpropertyValue(String propertyName) {
		String propertyValue = "";
	
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(CONFIG_FILE_PATH));
				propertyValue = prop.getProperty(propertyName);
			} catch (Exception e) {
			}
		return propertyValue;
	}
	
	
	 public static void captureScreenshots(WebDriver driver , String testMethodName)
	 {
		 try {
		 String currentDateAndTime = new Date().toString().replaceAll(":","_");
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File srcFile= ts.getScreenshotAs(OutputType.FILE);
	 File destFile = new File(SCREENSHOT_PATH + testMethodName + currentDateAndTime+ ".png");
	 Files.copy(srcFile,destFile);
		 }
	 catch(IOException e) {
	 
	 }
	 }
}