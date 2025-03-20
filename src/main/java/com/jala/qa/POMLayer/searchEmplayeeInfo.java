package com.jala.qa.POMLayer;

import java.awt.print.PageFormat;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.TesBaseLayer.testBase1;

public class searchEmplayeeInfo extends testBase1 {

	public searchEmplayeeInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "tblEmployee")
	WebElement table;
	
	@FindBy(xpath = "//tbody[1]")
	WebElement tableRow; 
	
	@FindBy(id = "MobileNo")
	WebElement mobileNo;
	
	@FindBy(id = "btnSearch")
	WebElement searchBtn;
	
	public void enterMobileNumber(String moNo) {
		mobileNo.sendKeys(moNo);
		searchBtn.click();
	}

	public String getSaerchData() {
		String getRowText = tableRow.getText();
		return getRowText;
	}
}
