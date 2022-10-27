package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.BaseClass;
import org.baseClass.StudPOJO;
import org.openqa.selenium.WebElement;
import org.pom.pages.StduentDashBoard;

public class UtilitiesClass extends BaseClass {
	
	static Map<String, String> loginCredentials;
	
	static Map<String, StudPOJO> studentDetails;
	
    //Excel Read method
	public Map<String, String> excelRead() {

		FileInputStream fi = null;
		Workbook wb = null;

		File loc=new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\TestData\\TestData.xlsx");

		try {
			fi = new FileInputStream(loc);
		}

		catch(Exception e) {
			e.printStackTrace();
		}

		try {
			wb = new XSSFWorkbook(fi);
		}

		catch(Exception e) {
			e.printStackTrace();
		} 

		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		int lastRow = sheet.getLastRowNum();

		loginCredentials =new LinkedHashMap<>();
	

		DataFormatter df=new DataFormatter();
		for (int i=1; i<=lastRow; i++) {

			String stdID = df.formatCellValue(sheet.getRow(i).getCell(2));
			String mobNo = df.formatCellValue(sheet.getRow(i).getCell(5));
			loginCredentials.put(stdID, mobNo);
					
		}
				
		return loginCredentials;
		
	}
	
	//Excel Read StudentDetailsPOJO method
		public Map<String, StudPOJO> excelReadStudentDetails() {

			FileInputStream fi = null;
			Workbook wb = null;

			File loc=new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\TestData\\TestData.xlsx");

			try {
				fi = new FileInputStream(loc);
			}

			catch(Exception e) {
				e.printStackTrace();
			}

			try {
				wb = new XSSFWorkbook(fi);
			}

			catch(Exception e) {
				e.printStackTrace();
			} 

			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);

			int lastRow = sheet.getLastRowNum();
			
			studentDetails =new LinkedHashMap<String, StudPOJO>();

			DataFormatter df=new DataFormatter();
			for (int i=1; i<=lastRow; i++) {

				String stdID = df.formatCellValue(sheet.getRow(i).getCell(2));
				String mobNo = df.formatCellValue(sheet.getRow(i).getCell(5));						
				String stdName = df.formatCellValue(sheet.getRow(i).getCell(3));
				String cRank = df.formatCellValue(sheet.getRow(i).getCell(20));
				String dRank = df.formatCellValue(sheet.getRow(i).getCell(21));
				String sRank = df.formatCellValue(sheet.getRow(i).getCell(22));
				
	        studentDetails.put(stdID, new StudPOJO(stdID, stdName,  mobNo, cRank, dRank, sRank));
				
			}
			
			return studentDetails;
		}

	
	//Excel write Method
	  
	    
	    public void excelWriteUtil() throws IOException     {
	    	
	    	// workbook object
	        XSSFWorkbook wb = new XSSFWorkbook();
	  
	        // spreadsheet object
	        XSSFSheet sheet = wb.createSheet("MM1Tracker");
	  
	        // creating a row object
	        XSSFRow row;
	  
	        // This data needs to be written (Object[])
	        
	               
	       // for(int i=1; i<sheet.getPhysicalNumberOfRows();i++) {
	        Map<String, Object[]> studentData = new LinkedHashMap <String, Object[]>();
	        
//	        //to fetch details from appln
//	        StduentDashBoard db=new StduentDashBoard();
//	        
//	        WebElement sName = db.getcStudentName();
//			String sName1 = sName.getText();
			

			
	        //to get details from read test data method from baseclasss
			
			
	        StudPOJO studPOJO = studentDetails.get(StduentDashBoard.username1);
			
			String stdID = studPOJO.getStdID() ;  
			String stdRank = studPOJO.getcRank();
			String stdName = studPOJO.getStdName();
			
	  
	        studentData.put(stdName, new Object[] {stdID, stdName, stdRank});
	        
	        
	        
	        
	       
	    System.out.println("STUDENT DETAILS in Excelwrite:"+stdID);
	//  
	        Set<String> keyid = studentData.keySet();
	  
	        int rowid = 0;
	  
	        // writing the data into the sheets...
	           	  
	        for (String key : keyid) {
	        	

	            row = sheet.createRow(rowid++);
	            Object[] objectArr = studentData.get(key);
	            int cellid = 0;
	  
	            for (Object obj : objectArr) {
	                Cell cell = row.createCell(cellid++);
	                cell.setCellValue((String)obj);
	                
	                
	            }
	            
	            FileOutputStream out = new FileOutputStream(
	     	            new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\TestData\\MismatchTracker.xlsx"));    
	    	        wb.write(out);
	    	        out.close();    
	        }
	        
	        // .xlsx is the format for Excel Sheets...
	        // writing the workbook into the file...
//	        FileOutputStream out = new FileOutputStream(
//	            new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\TestData\\MismatchTracker.xlsx"));
//	  
//	        wb.write(out);
//	        out.close();
	    }
	    }

	


