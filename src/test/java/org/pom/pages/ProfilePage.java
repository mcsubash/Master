package org.pom.pages;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="student_id")	
private WebElement studentID;

@FindBy(id="name")	
private WebElement studentName;

@FindBy(name="permanent_address")	
private WebElement permanentAddress;


@FindBy(name="present_address")	
private WebElement presentAddress;

@FindBy(xpath="//*[@id='submitbtn']")	
private WebElement submitBtn;

@FindBy(xpath="//*[@id='mother_mobile']")	
private WebElement motherMobile;

@FindBy(xpath="//*[@id='mother_occupation']")	
private WebElement motherOccupation;

@FindBy(xpath="//*[@id='mother_name']")	
private WebElement motherName;

@FindBy(xpath="//*[@id='father_mobile']")	
private WebElement fatherMobile;

@FindBy(xpath="//*[@id='father_occupation']")	
private WebElement fatherOccupation;

@FindBy(xpath="//*[@id='father_name']")	
private WebElement fatherName;

@FindBy(xpath="//*[text()='Personal Info']")	
private WebElement personalInfo;

@FindBy(xpath="//*[text()='Log out']")	
private WebElement logOut;

public WebElement getStudentID() {
	return studentID;
}

public WebElement getStudentName() {
	return studentName;
}

public WebElement getPermanentAddress() {
	return permanentAddress;
}

public WebElement getPresentAddress() {
	return presentAddress;
}

public WebElement getSubmitBtn() {
	return submitBtn;
}

public WebElement getMotherMobile() {
	return motherMobile;
}

public WebElement getMotherOccupation() {
	return motherOccupation;
}

public WebElement getMotherName() {
	return motherName;
}

public WebElement getFatherMobile() {
	return fatherMobile;
}

public WebElement getFatherOccupation() {
	return fatherOccupation;
}

public WebElement getFatherName() {
	return fatherName;
}

public WebElement getPersonalInfo() {
	return personalInfo;
}

public WebElement getLogOut() {
	return logOut;
}


}
