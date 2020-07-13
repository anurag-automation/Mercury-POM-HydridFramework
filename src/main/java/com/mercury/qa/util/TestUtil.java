package com.mercury.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mercury.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGELOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATAFILE_PATH = "C:\\Users\\Anurag\\eclipse-workspace\\MercuryToursTest"
			+ "\\src\\main\\java\\com\\mercury\\qa\\testdata\\MercuryTestData.xlsx";
	
    static Workbook book;
	static Sheet sheet;

	public static Object[][]getTestData(String sheetname){
		
		FileInputStream file = null;
		
		 try {
			file = new FileInputStream(TESTDATAFILE_PATH);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		 try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
		e.printStackTrace();
		}
		 
		 sheet = book.getSheet(sheetname);
		 
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 	for(int i=0; i<sheet.getLastRowNum();i++) {
		 		
		 		for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
		 			
		 			data[i][k] = sheet.getRow(i+1).getCell(k).toString().trim();
		 			
		 			System.out.println(data[i][k]);
		 			
		 		}
		 	}
			return data;
	}
	
	
	
}
