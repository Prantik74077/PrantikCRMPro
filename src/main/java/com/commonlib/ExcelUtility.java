package com.commonlib;

import java.io.FileInputStream;   
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility implements AutoConstant
{
        public String getExcelData(String sheetName,int rowNum,int colNum) throws Throwable
        {
    	FileInputStream fis=new FileInputStream(excelpath);
    	Workbook wb = WorkbookFactory.create(fis);
    	
    	Sheet sh = wb.getSheet(sheetName);
    	Row row = sh.getRow(rowNum);
    	wb.close();
		return row.getCell(colNum).getStringCellValue();
        }
    
        public void setExcelData(String sheetName,int rowNum,int colNum,String data) throws Throwable
        {
        	FileInputStream fis=new FileInputStream(excelpath);
        	Workbook wb = WorkbookFactory.create(fis);
         	
        	Sheet sh = wb.getSheet(sheetName);
        	Row row = sh.getRow(rowNum);
        	Cell cel = row.createCell(colNum);
        	cel.setCellValue(data);
        	FileOutputStream fos=new FileOutputStream(excelpath);
        	wb.write(fos);
        	wb.close();
        }
        
        public int getRowCount(String sheetName) throws Throwable
        {
    	FileInputStream fis=new FileInputStream(excelpath);
    	Workbook wb = WorkbookFactory.create(fis);
    	return wb.getSheet(sheetName).getLastRowNum(); 	
        }
    
    
}
