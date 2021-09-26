package UrbanLadder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;

public class NavBarItems extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void validateAppNavBar() throws IOException, InterruptedException {
		
		LandingPage l = new LandingPage(driver);
		/*Thread.sleep(1000L);
		l.closePopUp().click();*/
		Assert.assertTrue(l.getNavBar().isDisplayed());
		log.info("Navigation Bar is present");

}
	
	
	@Test
	public void CheckNavItems() {
		LandingPage l = new LandingPage(driver);
		l.getStudyItem().click();
		l.getLaptopTables().click();
		
		log.info("Successfully navigated to Laptop Tables page");
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed successfully");
	}
	
	

}
