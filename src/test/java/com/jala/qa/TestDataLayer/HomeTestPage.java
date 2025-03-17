package com.jala.qa.TestDataLayer;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.POMLayer.homePage;
import com.jala.qa.TesBaseLayer.testBase1;

public class HomeTestPage extends testBase1{
	LoginPage login;
	homePage home;
	public HomeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intilization();
		 login = new LoginPage();
		 login.validateLoginpage(prop.getProperty("UserName"), prop.getProperty("PassWord"));
		  home = new homePage();
	}
	
	@Test
	public void validateHomePage() {
		String getTextOfHomePage = home.getHomePageText();
		Assert.assertEquals(getTextOfHomePage, "Welcome to JALA Academy", "check the home text");
		Reporter.log("TC Passed, Home text mateched", true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
