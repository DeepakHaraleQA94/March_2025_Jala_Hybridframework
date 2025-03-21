package com.jala.qa.TestLayer;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.POMLayer.CreateEmployeePage;
import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.POMLayer.homePage;
import com.jala.qa.TesBaseLayer.testBase1;
import com.jala.qa.utilityLayer.getDataFromExcel;

public class CreateEmployeeDeatils extends testBase1{
	homePage home ;
	CreateEmployeePage emp;
	getDataFromExcel data;
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
	
//	@DataProvider
//	public Object[][] getData() {
//		Object[][] data = {{"dipak","abc"},
//						{"dipak1","abc1"}};
//		return data;
//	}
	@DataProvider
	
	public Object[][] getData() throws IOException {
		  data = new getDataFromExcel();
		Object[][] fetchData = data.getExcelData("Sheet2");
//		System.out.println(fetchData);
		return fetchData;
	}
	
	@Test(dataProvider = "getData", enabled = true)
	public void validateEmplyeeDetails(String Fname, String Lname, String email, 
			String MoNo,String DOB,String gender, String address, String country,String city,
			String skills) throws InterruptedException {
		home.clickOnCreateTab();
		emp.enterFirstName(Fname);
		emp.enterLastName(Lname);
		emp.enterMailId(email);
		emp.enterMobileNumber(MoNo);
		emp.enterDOB(DOB);
		emp.selctgender(gender);
		emp.enterAddress(address);
		holdTime();
		emp.selectCountryname(country);
		emp.selectCityName(city);
		emp.selectSkillSet(skills);
		holdTime();
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
