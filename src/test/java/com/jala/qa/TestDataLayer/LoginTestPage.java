package com.jala.qa.TestDataLayer;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.TesBaseLayer.testBase1;

public class LoginTestPage extends testBase1 {
	LoginPage login;
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intilization();
		login = new LoginPage();
		
	}

	@Test(priority = 1)
	public void verifyValidLoginCredential() throws IOException, InterruptedException {
	
//		System.out.println(login.getEmailText());
		login.validateLoginpage(login.getEmailText(), login.getPassText());
		holdTime();
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Magnus", "please check pageTitle for Home Page");
		Reporter.log("Home Page title matched", true);
	}
	
	
	@Test(priority = 2)
	public void validateInvalideCredential() {
		login.validateLoginpage("admin", "admin123");
		String getErrortext = login.getErrorMessage();
		Assert.assertEquals(getErrortext, "Invalid Email address or Password.", "please check the invalid crendential");
		Reporter.log("Test case Passed, invalid crential",true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
