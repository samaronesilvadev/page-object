package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {
		// TODO Auto-generated constructor stub
	}

	public void readExcel(String filepath, String sheetName) throws IOException {
	
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
	}
}
