package org.pom.pages;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.baseClass.BaseClass;
import org.baseClass.PropertiesUrls;
import org.baseClass.StudPOJO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.UtilitiesClass;

public class StduentDashBoard extends BaseClass {
	
	
	
	public StduentDashBoard() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ovpb")
	private WebElement collegeButtonOPI;
	
	@FindBy(xpath="(//p[@class='text-center mb-0'])[1]") 
	private WebElement cStudentName;
	
	@FindBy(xpath="//p[@class='text-center mb-0'])[2]")
	private WebElement cTopperName;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-left width-one'])[1]")
	private WebElement cStudentRank;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-left width-two'])[1]")
	private WebElement cStudentSkill;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-left width-three'])[1]")
	private WebElement cStudentAchievement;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-left width-four'])[1]")
	private WebElement cStudentAcademics;
	
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-right width-one'])[1]")
	private WebElement ctopperRank;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-right width-two'])[1]")
	private WebElement ctopperSkill;
	
	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-right width-three'])[1]")
	private WebElement ctopperAchievement;
	

	@FindBy(xpath="(//span[@class='digit-rating arrowBox curve-right width-four'])[1]")
	private WebElement ctopperAcademics;


	public WebElement getCollegeButtonOPI() {
		return collegeButtonOPI;
	}


	public WebElement getcStudentName() {
		return cStudentName;
	}


	public WebElement getcTopperName() {
		return cTopperName;
	}


	public WebElement getcStudentRank() {
		return cStudentRank;
	}


	public WebElement getcStudentSkill() {
		return cStudentSkill;
	}


	public WebElement getcStudentAchievement() {
		return cStudentAchievement;
	}


	public WebElement getcStudentAcademics() {
		return cStudentAcademics;
	}


	public WebElement getCtopperRank() {
		return ctopperRank;
	}


	public WebElement getCtopperSkill() {
		return ctopperSkill;
	}


	public WebElement getCtopperAchievement() {
		return ctopperAchievement;
	}


	public WebElement getCtopperAcademics() {
		return ctopperAcademics;
	}
	
	public static String username1;// declared static in order to use in excelwrite-util
	String password1;
	static Map<String, String> loginCredentials;
	static Map<String, StudPOJO> studentDetails;
	Map<String, String> studentUsernameAndRank;
	String stduentAppID;
	String studentAppRank;
	

	String stdName;
	String colRank;
	String distRank;
	String stateRank;
	
	public void fetchRankFromDashBoard(String rankLevel) throws InterruptedException, IOException {
		

		int nameCount=1;
		int rankCount=1;
		browserLaunch("chrome");
		StduentDashBoard sd=new StduentDashBoard();
		StudetntLoginPage sl= new StudetntLoginPage(); 
		UtilitiesClass util=new UtilitiesClass();
		
		loginCredentials = util.excelRead();

		Set<Entry<String, String>> entrySet = loginCredentials.entrySet();
		for (Entry<String, String> cred : entrySet) {

			username1 = cred.getKey();
			password1 = cred.getValue();
			//System.out.println(username1+"    "+password1);

			//stdLogin(username, password);	
			
			sl.studentLogin(username1, password1);
			Thread.sleep(3000);
			
		switch(rankLevel) {
		
		case "college": 
			driver.findElement(By.id("ovpb")).click();	
			break;

		case "district": 
            driver.findElement(By.id("ovpb1")).click();
            break;

		case "state": 
			driver.findElement(By.id("ovpb2")).click();
			break;
		
		}
		studentUsernameAndRank= new LinkedHashMap<>();
		String sname = driver.findElement(By.xpath("(//p[@class='text-center mb-0'])["+nameCount+"]/b")).getText();
		//System.out.println(sname);
		String srank = driver.findElement(By.xpath("(//span[@class='digit-rating arrowBox curve-left width-one'])["+rankCount+"]")).getText();
		//System.out.println(srank);
				
		studentUsernameAndRank.put(username1, srank);
		
		
Set<Entry<String, String>> entrySet1 = studentUsernameAndRank.entrySet();
		
		for (Entry<String, String> x : entrySet1) {
			
			
			stduentAppID = x.getKey();
			studentAppRank = x.getValue();
			System.out.println("stduentAppID:  "+stduentAppID);
			System.out.println("studentAppRank: "+studentAppRank);
		}
		
		
		UtilitiesClass util1=new UtilitiesClass();
		studentDetails = util1.excelReadStudentDetails();
		
		//System.out.println("StudentDetails:"+studentDetails);
		
		
		Set<Entry<String, StudPOJO>> entrySet2 = studentDetails.entrySet();
		
		
		
		
		for (Entry<String, StudPOJO> entrystudentDetails : entrySet2) {
		
			StudPOJO studPOJO = studentDetails.get(username1);
			
			
		stdName = studPOJO.getStdName();
		colRank = studPOJO.getcRank();
		distRank = studPOJO.getdRank();
		stateRank = studPOJO.getsRank();
		
		//Thread.sleep(3000);
		//compare rank from appln and source data
		if(rankLevel.equals("college")){
		
		if(!studentAppRank.equals(colRank)){
			UtilitiesClass util2=new UtilitiesClass();
			
			util2.excelWriteUtil();



		
		}
//		Thread.sleep(3000);
//		if(rankLevel.equals("college")){
//		
//		if(!studentAppRank.equals(colRank)){
//			UtilitiesClass util2=new UtilitiesClass();
//			
//			util2.excelWriteUtil();

			System.out.println("Compare college ranks: "+studentAppRank+" "+colRank);
		}
		//System.out.println("College,district and state Ranks: "+stdName+" "+colRank+" "+distRank+" "+stateRank);			
		
		
		
		
		}

		
		
		
		
		//logout
		Thread.sleep(3000);
		WebElement logOut1 = driver.findElement(By.xpath("//span[text()='Log out']"));
		//wait.until(ExpectedConditions.visibilityOf(logOut1));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", logOut1);
		
		logOut1.click();

		}
		
		nameCount+=2;
		rankCount++;
		}	
	
					
	public void compareRankinTestDataAndAppln(String rankLevel) throws IOException {
		
		
		
		Set<Entry<String, String>> entrySet1 = studentUsernameAndRank.entrySet();
		
		for (Entry<String, String> x : entrySet1) {
			
			
			stduentAppID = x.getKey();
			studentAppRank = x.getValue();
			System.out.println("stduentAppID:  "+stduentAppID);
			System.out.println("studentAppRank: "+studentAppRank);
		}
		
		
		UtilitiesClass util=new UtilitiesClass();
		studentDetails = util.excelReadStudentDetails();
		
		//System.out.println("StudentDetails:"+studentDetails);
		
		
		Set<Entry<String, StudPOJO>> entrySet2 = studentDetails.entrySet();
		
		
		
		
		
		for (Entry<String, StudPOJO> entrystudentDetails : entrySet2) {
		
			StudPOJO studPOJO = studentDetails.get(username1);
			
			
		String stdName = studPOJO.getStdName();
		String colRank = studPOJO.getcRank();
		String distRank = studPOJO.getdRank();
		String stateRank = studPOJO.getsRank();
		
		System.out.println(studPOJO);
		System.out.println("College,district and state Ranks: "+stdName+" "+colRank+" "+distRank+" "+stateRank);
		
//		if(rankLevel.equals("college")){
//			
//			if(!studentAppRank.equals(colRank)){
//				ExcelWrite ew= new ExcelWrite();
//				ew.excelWrite();
//			}	
//			}
		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		StduentDashBoard sd=new StduentDashBoard();
		StudetntLoginPage sl= new StudetntLoginPage(); 
		
		Thread.sleep(3000);
		
		
		sd.fetchRankFromDashBoard("college");
		
		
		// browserLaunch("chrome");
		
		//sl.loginMultipleStudents();

			
		
//		Thread.sleep(3000);
//		sd.fetchRankFromDashBoard("college");
//
//
//Thread.sleep(3000);
//		WebElement logOut1 = driver.findElement(By.xpath("(//span[@class='menu-title text-truncate'])[9]"));
//		WebDriverWait wait=new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(logOut1));
//		logOut1.click();

	}
	
	
			
	
}
