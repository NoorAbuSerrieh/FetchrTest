package com.fetchr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fetchr.Base.TestBase;

public class TestUtils extends TestBase{
	public TestUtils() throws IOException {
		super();
		
	}

	public static void TakeScreenshot(String name) throws IOException
	{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	FileUtils.copyFile(srcFile, new File("..\\FetchrWebsiteTest\\TestReport\\"+name+".png"));
	}
	
	public static Object[][] getDataFromExcel(String sheetName) throws IOException {
		
		File file = new File("..\\FetchrWebsiteTest\\TestData\\FetchrTestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		Sheet sheet = workBook.getSheet(sheetName);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		
		
		Object data[][] = new Object[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < cols; k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				}
		}
		
		return data;
	
	}

}
