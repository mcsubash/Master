package org.pom.pages;

import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
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


}
