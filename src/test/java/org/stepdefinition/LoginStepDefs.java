package org.stepdefinition;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseClass.BaseClass;
import org.baseClass.StudPOJO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.pages.StudetntLoginPage;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefs extends BaseClass {
	
	StudetntLoginPage l;
	WebDriverWait wait;
	StudPOJO sPOJO;
	
	
	@Given("the user should be in student dashboard page")
	public void the_user_should_be_in_student_dashboard_page() {
		browserLaunch("chrome");
		urlLaunch("http://maplogik.com/index.php/student/login");
		
	}

	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() throws IOException {
				
	    
		l=new StudetntLoginPage();	
						
			sendKeys(l.getStudentID(), excelRead("TestData", "Sheet1", 18, 2));
			sendKeys(l.getMobileNo(), excelRead("TestData", "Sheet1", 18, 5));
		}

	
	@When("The user clicks the Login button")
	public void the_user_clicks_the_Login_button() throws InterruptedException {
		buttonClick(l.getLogin()); 

		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(l.getOtp()));
		
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
	
//	@Then("logout")
//	public void logout() {
//		
//		wait.until(ExpectedConditions.elementToBeClickable(l.getLogOut())).click();
//		
//	}
}
