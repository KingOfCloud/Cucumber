package org.day2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
public static void main(String[] args) {
	
	String s ="May-10.xlsx";
	
	String[][] data= {
			{"Name","Age"},
			{"Ram","20"},
			{"Raja","20"},
			{"Sree","21"},
			{"Vini","22"}
	
	};
	try (FileOutputStream stream = new FileOutputStream(s); 
			Workbook book=new XSSFWorkbook();){
		
		Sheet sheet = book.createSheet("Student");
		for(int i=0;i<data.length;i++) {
			Row r= sheet.createRow(i);
		
			for(int j=0;j<data[i].length;j++) {
				r.createCell(j).setCellValue(data[i][j]);	
			}	
			}
		for(int i=0;i<data.length;i++) {
			sheet.autoSizeColumn(i);
		}
		book.write(stream);
		System.out.println("Data Write");
		
	} catch (Exception e) {
		
	}
}
}
