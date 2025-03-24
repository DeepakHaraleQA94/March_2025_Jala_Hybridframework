package com.jala.qa.utilityLayer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getDataFromExcel {

	

	public Object[][] getExcelData(String sheetNum) throws IOException {
		String path ="C:\\Users\\Sarvadnya\\eclipse-workspace\\March2025_NewProject\\March_2025_Jala_Hybridframework\\src\\test\\java\\com\\jala\\qa\\DataLayer\\EmployeeData.xlsx";
		FileInputStream pathOfExcel = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(pathOfExcel);
		XSSFSheet sheetName = book.getSheet(sheetNum);
		
		Object[][] data = new Object[sheetName.getLastRowNum()][sheetName.getRow(0).getLastCellNum()];
		for(int i=1;i<sheetName.getLastRowNum();i++) {
			for(int c=0; c<sheetName.getRow(i).getLastCellNum();c++) {
				data[i][c] = sheetName.getRow(i).getCell(c).toString();
//				System.out.println(sheetName.getRow(i).getCell(c).toString());
			}
			
		
		}
		return data;
	
	}
}
