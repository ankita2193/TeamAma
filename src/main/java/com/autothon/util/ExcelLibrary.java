package com.autothon.util;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLibrary {
String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";

	public String GetExcelData(String sheetName, int rowNum, int colNum) throws IOException {
	FileInputStream fis = null;
	String data = "";
	try {
		fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);

		data = row.getCell(colNum).getStringCellValue();
		} 
	catch (Exception e) 
	{
		fis.close();
	}
	return data;
}

public String getDataRangefromExcel(String sheetName, int colNum) throws IOException, AWTException {
	int startrow = 0;
	boolean exitvar = false;
	FileInputStream fis = new FileInputStream(path);
	Workbook wb;
	String cellValue = "";
	try {
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int noOfRows = sh.getLastRowNum() + 1;
		for (int i = startrow; i < noOfRows; i++) {
			boolean flag = false;
			for (int j = 0; j < colNum; j++) {
				Row row = sh.getRow(i);
				Cell cell = row.getCell(j);
				if ((cell.getStringCellValue().equalsIgnoreCase("END")) || (cell.getStringCellValue() == null)) {
					exitvar = true;
					break;
				} 
				else {
					String t = flag ? "\t" : "";
					flag = true;
					cellValue = cellValue + t + sh.getRow(i).getCell(j).getStringCellValue();
				}
			} // end for j loop
			cellValue = cellValue + " \n";
			if (exitvar)
				break;
		} // end for i loop

	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	return cellValue;
	}

	public void setExcelData(Boolean status, String sheetName, int rowNum, int colNum) {
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(colNum);
			if (status == true) {
				cell.setCellValue("Pass");
			} 
			else {
				cell.setCellValue("Fail");
			}
			FileOutputStream outFile = new FileOutputStream(path);
			book.write(outFile);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}