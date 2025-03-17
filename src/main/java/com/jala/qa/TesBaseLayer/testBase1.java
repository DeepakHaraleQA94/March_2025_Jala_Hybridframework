package com.jala.qa.TesBaseLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testBase1 {
	public static Properties prop;
	public static WebDriver driver;
	public testBase1() throws IOException{
		 prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Sarvadnya\\eclipse-workspace\\March2025_JalaProject\\src\\main\\java\\com\\jala\\qa\\PropertyLayer\\config.properties");
		prop.load(file);
	}
	
	public void intilization() {
		
		String browser = prop.getProperty("Browsername");
		if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")){
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
	}
	
	public void holdTime() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	
}
