package com.jala.qa.TestDataLayer;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.POMLayer.CreateEmployeePage;
import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.POMLayer.homePage;
import com.jala.qa.TesBaseLayer.testBase1;

public class CreateEmployeeDeatils extends testBase1{
	homePage home ;
	CreateEmployeePage emp;
	public CreateEmployeeDeatils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod 
	public void setUp() throws IOException {
		intilization();
		LoginPage login = new LoginPage();
		login.validateLoginpage(prop.getProperty("UserName"), prop.getProperty("PassWord"));
	 home = new homePage();
	  emp = new CreateEmployeePage();
	}
	
	@Test
	public void validateEmplyeeDetails() throws InterruptedException {
		home.clickOnCreateTab();
		emp.enterFirstName("jonh");
		emp.enterLastName("siman");
		emp.enterMailId("abc@gmail.com");
		emp.enterMobileNumber("8979879686");
		emp.enterDOB("09/04/1998");
		emp.selectMaleOption();
		emp.enterAddress("pune");
		emp.selectCountryname("India");
		emp.selectCityName("Mumbai");
		emp.selectSkills();
		emp.clickOnSaveButton();
		holdTime();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Search Employee", "check the title of search page");
		Reporter.log("TC passed, Title matched",true);
				
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
