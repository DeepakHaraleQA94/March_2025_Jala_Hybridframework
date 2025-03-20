package com.jala.qa.utilityLayer;

import java.io.IOException;

import com.jala.qa.POMLayer.LoginPage;
import com.jala.qa.TesBaseLayer.testBase1;

public class loginFucntion extends testBase1 {
LoginPage login;
	public loginFucntion() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void loginCredential() throws IOException {
		login= new LoginPage();
	 login.validateLoginpage(prop.getProperty("UserName"), prop.getProperty("PassWord"));
		
	}

}
