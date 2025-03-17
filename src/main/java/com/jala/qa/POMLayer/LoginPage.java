package com.jala.qa.POMLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.TesBaseLayer.testBase1;

public class LoginPage extends testBase1 {

	public  LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "UserName")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath ="//h5[contains(text(),'Email ')]" )
	WebElement emailText;
	
	@FindBy(xpath ="//h5[contains(text(),'Password ')]" )
	WebElement getPass;
	
	@FindBy(xpath = "//div[text()='Invalid Email address or Password.']")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		String displayError = errorMessage.getText();
		return displayError;
	}
	
	public String getEmailText() {
		String emailText1 = emailText.getText();
		String[] devideEmailtext = emailText1.split(":");
		String Email = devideEmailtext[1].trim();
		return Email;
	}
	
	public String getPassText() {
		String passText1 = getPass.getText();
		String[] devidePasstext = passText1.split(":");
		String pass = devidePasstext[1].trim();
		return pass;
	}
	
	
	public void validateLoginpage(String uName, String pass) {
		username.sendKeys(uName);
		Password.sendKeys(pass);
		btnLogin.click();
	}
	
	
	
	
}
