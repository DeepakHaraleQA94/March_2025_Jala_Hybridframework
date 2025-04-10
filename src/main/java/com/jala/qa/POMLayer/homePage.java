package com.jala.qa.POMLayer;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.TesBaseLayer.testBase1;

public class homePage extends testBase1 {

	public homePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Welcome to JALA Academy']")
	WebElement homePageText;
	
	@FindBy(linkText = "http://jalatechnologies.com")
	WebElement linkOfHomePage;
	
	@FindBy(linkText = "Employee")
	WebElement employeeTab;
	
	@FindBy(linkText = "Create")
	WebElement createTab;
	
	
	@FindBy(linkText = "Search")
	WebElement searchtab;
	public String getHomePageText() {
		String getText = homePageText.getText();
		
		return getText;
	}
	
	
	public String getHomePageTextLink() {
		String getTextLink = linkOfHomePage.getText();
		
		return getTextLink;
	}
	
	public void clickOnCreateTab() {
		employeeTab.click();
		createTab.click();
	}
	
	public void clickOnSearchTab() {
		employeeTab.click();
		searchtab.click();
	}
}
