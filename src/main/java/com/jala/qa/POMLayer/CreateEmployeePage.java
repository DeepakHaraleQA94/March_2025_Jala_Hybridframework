package com.jala.qa.POMLayer;

import java.awt.print.PageFormat;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jala.qa.TesBaseLayer.testBase1;

public class CreateEmployeePage extends testBase1{

	public CreateEmployeePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement LastName;
	
	@FindBy(id = "EmailId")
	WebElement email;
	
	@FindBy(id = "MobileNo")
	WebElement mobileNo;
	
	@FindBy(id = "DOB")
	WebElement dob;
	
	@FindBy(id = "rdbMale")
	WebElement male;
	
	@FindBy(id = "rdbFemale")
	WebElement feMale;
	
	@FindBy(id = "Address")
	WebElement address;
	
	@FindBy(id = "CountryId")
	WebElement contryName;
	
	@FindBy(id = "CityId")
	WebElement cityname;
	
	@FindBy(id = "chkSkill_1")
	WebElement QA_Automation;
	
	@FindBy(id="chkSkill_5")
	WebElement AWS;
	
	@FindBy(id="chkSkill_3")
	WebElement DevOps;
	
	@FindBy(id = "chkSkill_2")
	WebElement  fullStackDeveloper;
	
	@FindBy(id="chkSkill_4")
	WebElement Middleware;
	
	@FindBy(id = "chkSkill_6")
	WebElement WebServices;
	
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;
	
	public void selectSkillSet(String skill) {
		
		if(skill.equals("AWS")) {
			AWS.click();
		}else if(skill.equals("DevOps")) {
			DevOps.click();
		}else if(skill.equals("QA-Automation")) {
			QA_Automation.click();
		}
		else if(skill.equals("WebServices")) {
			WebServices.click();
		}else if(skill.equals("Middleware")) {
			Middleware.click();
		}
		
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String Lname) {
		LastName.sendKeys(Lname);
	}
	
	public void enterMailId(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterMobileNumber(String MoNo) {
		mobileNo.sendKeys(MoNo);
	}
	
	public void enterDOB(String DOB) {
		dob.sendKeys(DOB);
	}
	
	public void selctgender(String gender) {
		if(gender.equals("Male")) {
			male.click();
		}
		else {
			feMale.click();
		}
	}
	public void selectMaleOption() {
		male.click();
	}
	
	public void selectFemaleOption() {
		feMale.click();
	}
	
	public void enterAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void selectCountryname(String country) {
		Select select = new Select(contryName);
		select.selectByVisibleText(country);
	}
	
	public void selectCityName(String city) {
		Select select = new Select(cityname);
		select.selectByVisibleText(city);
		
	}
	
	public void selectSkills() {
		QA_Automation.click();
	}
	
	public void clickOnSaveButton() {
		saveBtn.click();
	}
}

