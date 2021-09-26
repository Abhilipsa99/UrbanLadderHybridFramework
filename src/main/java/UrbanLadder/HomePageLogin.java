package UrbanLadder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class HomePageLogin extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void Login() throws InterruptedException, IOException {
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		l.selectLogin().click();
		Thread.sleep(2000L);
		
		log.info("Navigated to Login Page");
		
		LoginPage lp = new LoginPage(driver);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\data.properties");
		prop.load(fis);
		String email = prop.getProperty("emailAddress");
		String password = prop.getProperty("password");
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		
		log.info("Driver is closed successfully");
	}


}
