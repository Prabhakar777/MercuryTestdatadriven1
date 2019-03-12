package com.cjc.Testdatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ecxeldataconfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public void testdata1(String File) throws IOException
	{
		FileInputStream fis =new FileInputStream(File);
		wb=new XSSFWorkbook(fis);
	}
	
	public int getRowcount(String sheetname)
	{
		sheet=wb.getSheet(sheetname);
		int rows=sheet.getLastRowNum();
		int rowcount=rows+1;
		return rowcount;
	}
   public int getcolumncount(String sheetname)
   {
	   sheet=wb.getSheet(sheetname);
	   int rows1=sheet.getLastRowNum();
	   int columns=sheet.getRow(rows1).getLastCellNum();
	   return columns;
   }
   
   public String getdata(String sheetname,int row,int column)
   {
	   sheet=wb.getSheet(sheetname);
	   String dataval=sheet.getRow(row).getCell(column).getStringCellValue();
	   return dataval;
   }
}
