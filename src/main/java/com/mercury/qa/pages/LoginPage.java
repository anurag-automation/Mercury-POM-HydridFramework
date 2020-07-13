package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page Factory or OR(Object Repository)
	
	@FindBy(name= "userName")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(name= "login")
	WebElement login;
	
	@FindBy(linkText= "SIGN-ON")
	WebElement signon;
	
	//Intializing the page objects:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	// Actions:
	
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public FlightFinder login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new FlightFinder();
		
		 
	}

}
