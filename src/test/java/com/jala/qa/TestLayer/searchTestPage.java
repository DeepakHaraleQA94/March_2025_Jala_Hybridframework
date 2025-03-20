package com.jala.qa.TestLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.POMLayer.homePage;
import com.jala.qa.POMLayer.searchEmplayeeInfo;
import com.jala.qa.TesBaseLayer.testBase1;
import com.jala.qa.utilityLayer.loginFucntion;

public class searchTestPage extends testBase1 {
	searchEmplayeeInfo search;

	public searchTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intilization();
		loginFucntion login = new loginFucntion();
		login.loginCredential();
		homePage home = new homePage();
		home.clickOnSearchTab();
		search = new searchEmplayeeInfo();
	}

	@Test
	public void validateSearchPage() {
		search.enterMobileNumber("(079)25727");
		 String getTextData = search.getSaerchData();
		
		 boolean searchMail = getTextData.contains("laverna.sipes@gmail.com");
		 Assert.assertTrue(searchMail, "email not matched");
		 Reporter.log("email matched",true);
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
