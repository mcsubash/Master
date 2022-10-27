package org.pom.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.BaseClass;
import org.baseClass.PropertiesUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.UtilitiesClass;

public class StudetntLoginPage extends BaseClass {

	String username1;
	String password1;
	static Map<String, String> loginCredentials;
	
	public StudetntLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login-student-id")	
	private WebElement studentID;

	@FindBy(id="login-mobile")
	private WebElement mobileNo;

	@FindBy(xpath="//button[text()='Log in']")
	private WebElement login;

	@FindBy(id="test_otp")	
	private WebElement otp;

	@FindBy(id="login-otp")	
	private WebElement otpText;

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath="(//span[@class='menu-title text-truncate'])[2]")
	private WebElement profile;


	@FindBy(xpath="(//span[@class='menu-title text-truncate'])[9]")
	private WebElement logOut;


	public WebElement getStudentID() {
		return studentID;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getOtp() {
		return otp;
	}

	public WebElement getOtpText() {
		return otpText;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	int count;
	public void stdLogin(String username, String password) throws InterruptedException {
        //driver.get("http://maplogik.com/index.php/student/login");
		PropertiesUrls prop = new PropertiesUrls();
		prop.stdUrlLaunch();
		sendKeys(studentID, username);
		sendKeys(mobileNo, password);
		buttonClick(login);

		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getOtp()));
		sendKeys(otpText, getOtp().getText());
		buttonClick(btnSubmit);
		//logOut();	
		count++;

	}

	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();

	}

		
	//Student LoginMultipleStudents method
//	public void loginMultipleStudents() throws InterruptedException {
//		UtilitiesClass util=new UtilitiesClass();
//		
//		loginCredentials = util.excelRead();
//
//		Set<Entry<String, String>> entrySet = loginCredentials.entrySet();
//		for (Entry<String, String> cred : entrySet) {
//
//			username1 = cred.getKey();
//			password1 = cred.getValue();
//			System.out.println(username1+"    "+password1);
//
//			//stdLogin(username, password);	
//			
//			studentLogin(username1, password1);
//			
//					
//		}
//
//		System.out.println("Total count: "+count);
//		}

    //student login alternate without POM
	
	public void studentLogin(String username1, String password1) throws InterruptedException {
	
   
	PropertiesUrls prop = new PropertiesUrls();
	prop.stdUrlLaunch();
	driver.findElement(By.id("login-student-id")).sendKeys(username1);
	driver.findElement(By.id("login-mobile")).sendKeys(password1);
	driver.findElement(By.xpath("//button[text()='Log in']")).click();

	WebDriverWait wait=new WebDriverWait(driver, 30);
	WebElement otp = driver.findElement(By.id("test_otp"));
	
	wait.until(ExpectedConditions.visibilityOf(otp));
	driver.findElement(By.id("login-otp")).sendKeys(otp.getText());
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	
 	}

}



