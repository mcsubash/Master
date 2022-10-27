package org.pom.pages;

// Java program to write data in excel sheet using java code
  
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.BaseClass;
import org.baseClass.StudPOJO;
import org.openqa.selenium.WebElement;
import org.utilities.UtilitiesClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;



  
public class ExcelWrite extends BaseClass {
	
	
	
	
	// any exceptions need to be caught
	public void excelWrite() throws IOException     {
		
		// workbook object
	    XSSFWorkbook wb = new XSSFWorkbook();

	    // spreadsheet object
	    XSSFSheet sheet = wb.createSheet("MMTracker");

	    // creating a row object
	    XSSFRow row;

	    // This data needs to be written (Object[])
	    
	           
	   // for(int i=1; i<sheet.getPhysicalNumberOfRows();i++) {
	    Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
	    
	    //to fetch details from appln
	    StduentDashBoard db=new StduentDashBoard();
	    
	    WebElement sName = db.getcStudentName();
		String sName1 = sName.getText();
		

		
	    //to get details from read test data method from baseclasss
//	    StudPOJO sPOJO = stdataMap.get(sName1);
//		
//		String stdID = sPOJO.getStdID() ;  
//		String stdRank = sPOJO.getcRank();
//		String stdName = sPOJO.getStdName();
		
		UtilitiesClass util1=new UtilitiesClass();
		Map<String, StudPOJO> studentDetails = util1.excelReadStudentDetails();
		
		StudPOJO studPOJO = studentDetails.get(sName1);
		
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
	    }

	    // .xlsx is the format for Excel Sheets...
	    // writing the workbook into the file...
	    FileOutputStream out = new FileOutputStream(
	        new File("D:\\eclipse-workspace\\CucumberMapLogik\\src\\test\\resources\\TestData\\MismatchTracker.xlsx"));

	    wb.write(out);
	    out.close();
	}

	public static void main(String[] args) throws IOException {
		
		UtilitiesClass util1=new UtilitiesClass();
		Map<String, StudPOJO> studentDetails = util1.excelReadStudentDetails();
		
		
		ExcelWrite ew = new ExcelWrite();
		ew.excelWrite();
		
		
	}
	
	          }

