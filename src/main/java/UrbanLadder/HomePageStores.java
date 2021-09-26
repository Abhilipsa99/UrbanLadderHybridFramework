package UrbanLadder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class HomePageStores extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void validateStores() throws InterruptedException {
		LandingPage l = new LandingPage(driver);
		/*Thread.sleep(1000L);
		l.closePopUp().click();*/
		l.getStores().click();
		
		LandingPage2 lp2 = new LandingPage2(driver);
		lp2.getStoreDetails().click();
		
		Assert.assertEquals(lp2.getTitle().getText(), "Urban Ladder Experience Centre - Bandra");
		
		log.info("Navigated to Urban Ladder Bandra Store page");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed successfully");
	}

}
