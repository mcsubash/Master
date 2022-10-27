package org.stepdefinition;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.BaseClass;
import org.baseClass.StudentsPOJO;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.pages.DashBoard;
import org.pom.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OPISteps extends BaseClass {

	// login
	LoginPage l;
	WebDriverWait wait;


	@Given("the user should be in student dashboard page")
	public void the_user_should_be_in_student_dashboard_page() {
		browserLaunch("chrome");
		urlLaunch("http://maplogik.com/index.php/student/login");
	}


	@When("enters the valid credentials to login student module")
	public void enters_the_valid_credentials_to_login_student_module() throws IOException {

		l=new LoginPage();	
		
			sendKeys(l.getStudentID(), excelRead("TestData", "Sheet1", 18, 2));
			sendKeys(l.getMobileNo(), excelRead("TestData", "Sheet1", 18, 5));
		
			}

	@When("The user clicks the Login button")
	public void the_user_clicks_the_Login_button() throws InterruptedException {
		buttonClick(l.getLogin()); 

		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(l.getOtp()));
		//Thread.sleep(3000);
	}

	@When("enters the OTP")
	public void enters_the_OTP() throws AWTException, InterruptedException {

		sendKeys(l.getOtpText(), getText(l.getOtp()));	

	}

	@When("clicks the Submit button")
	public void clicks_the_Submit_button() {

		buttonClick(l.getBtnSubmit());


	}

	@Then("student profile page should be opened")
	public void student_profile_page_should_be_opened() throws InterruptedException {

		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Apex Charts"));

		Assert.assertTrue("Verify Student Profile", getCurrentUrl().contains("student/dashboard"));

		String currentUrl = l.getCurrentUrl();
		System.out.println("Current URL is "+currentUrl);
	}



	//OPI
	DashBoard db;
	@When("the user clicks College button under Overall Position Indicator")
	public void the_user_clicks_College_button_under_Overall_Position_Indicator() {

		db= new DashBoard();

		buttonClick(db.getCollegeButtonOPI());

	}

	@When("gets the values from the Rank-field both for the User and the Topper")
	public void gets_the_values_from_the_Rank_field_both_for_the_User_and_the_Topper() {
	
		System.out.println();
	   System.out.println("Fetching Logged-in Student's Rank from Application;");
		System.out.println("Student's College Rank: "+db.getcStudentRank().getText());
		System.out.println("Toppers's College Rank: "+db.getCtopperRank().getText());
		
	}

	@Then("verify it matches the Source Test Data")
	public void verify_it_matches_the_Source_Test_Data() throws IOException {
		
      //Fetching the name from Application
		WebElement sName = db.getcStudentName();
		String sName1 = sName.getText();
		System.out.println("Student Name: "+sName1);
		
		System.out.println();
		System.out.println("Reading data from Excel:");
		readTestData();
		StudentsPOJO studentsPOJO = sdataMap.get(sName1);
		String stdID = studentsPOJO.getStdID() ;  
		String stdRank = studentsPOJO.getcRank();
		String stdName = studentsPOJO.getStudName();
		System.out.println(stdName+": "+stdRank.trim());
		
		
		
	if(stdRank.trim().equals(db.getcStudentRank().getText())){
		
		System.out.println("The Ranks are the same");
		
	}
	else {
		System.out.println("The Ranks are different");
		
		// workbook object
        XSSFWorkbook wb = new XSSFWorkbook();
  
        // spreadsheet object
        XSSFSheet sheet = wb.createSheet("MMTracker");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        
               
        for(int i=1; i<sheet.getPhysicalNumberOfRows();i++) {
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
  
        studentData.put(stdID,new Object[] {stdID, stdName, stdRank});
       
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
	}
		
	
		
	Assert.assertEquals("Verify rank in source data (excel) with application: ", stdRank.trim(), db.getcStudentRank().getText());	
		
		
		
	
//System.out.println("Student's POJO: "+sdataMap.get("M. Subash"));
//System.out.println("Logged-in Student's College Rank: "+ sdataMap.get("M. Subash ").getcRank());
	}



@Then("any data mismatch will be updated in the Mismatch Tracker")
public void any_data_mismatch_will_be_updated_in_the_Mismatch_Tracker() {
	
	
	
	

}



}
