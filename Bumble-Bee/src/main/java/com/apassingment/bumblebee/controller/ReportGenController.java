package com.apassingment.bumblebee.controller;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class ReportGenController extends HttpServlet{

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		        // Create a new Excel workbook
		        Workbook workbook = new XSSFWorkbook();

		        // Create a sheet in the workbook
		        Sheet sheet = workbook.createSheet("Sheet1");

		        // Create a row in the sheet
		        Row row = sheet.createRow(0);

		        // Create some cells in the row
		        Cell cell1 = row.createCell(0);
		        cell1.setCellValue("Hello");

		        Cell cell2 = row.createCell(1);
		        cell2.setCellValue("World");

		        // Write the workbook to a file
		        FileOutputStream fileOut = new FileOutputStream("example.xlsx");
		        workbook.write(fileOut);
		        fileOut.close();

		        // Close the workbook
		        workbook.close();
		    
		
   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	
	}
	
	
	    
}

	
	

