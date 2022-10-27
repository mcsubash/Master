package org.pom.pages;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends BaseClass {
	
	public DashBoard() {
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
	
	
	
	
	
		
	
			
	
}
