package org.pom.pages;

// Java program to write data in excel sheet using java code
  
import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.StudentsPOJO;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
  
public class ExcelWrite {
  
    // any exceptions need to be caught
    public static void main(String[] args) throws Exception
    {
        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet spreadsheet
            = workbook.createSheet("MMTracker");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        
               
        
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
  
        studentData.put("1",new Object[] {"stdID", "stdName", "stdRank"});
        studentData.put("2",new Object[] {"stdID", "stdName", "stdRank"});
  
//  
        Set<String> keyid = studentData.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
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
  
        workbook.write(out);
        out.close();
    }
}