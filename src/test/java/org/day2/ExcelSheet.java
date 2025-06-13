package org.day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
public static void main(String[] args) throws IOException {
	File f =new File("C:\\Users\\judso\\Downloads\\New.xlsx");
	
	//Read Data
	FileInputStream stream = new FileInputStream(f);
	
	Workbook book = new XSSFWorkbook(stream);
	
	Sheet sheet = book.getSheet("sheet1");
	for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
	Row row = sheet.getRow(i);
	for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
	Cell cell = row.getCell(j);
	
	String stringCellValue = cell.getStringCellValue();
	System.out.println(stringCellValue);
	
}
	}}
}
