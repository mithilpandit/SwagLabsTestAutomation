package com.swaglabs.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public String[][] excelRead()
	{
		DataFormatter formatter=new DataFormatter();
		String[][] data=null;
		File myFile=new File(System.getProperty("user.dir")+"/TestData/Login Check.xlsx");
		try {
		FileInputStream fis=new FileInputStream(myFile);
		XSSFWorkbook myBook=new XSSFWorkbook(fis);
		XSSFSheet mySheet=myBook.getSheet("Login Credentials");
		int totalRows=mySheet.getLastRowNum()+1;
		int totalCells=mySheet.getRow(0).getLastCellNum();
		
		data=new String[totalRows][totalCells];
		
		for(int i=1;i<totalRows;i++)
		{
			for(int j=0;j<totalCells;j++)
			{
				data[i-1][j]=formatter.formatCellValue(mySheet.getRow(i).getCell(j));
			}
		}
		myBook.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return data;
	}

}
