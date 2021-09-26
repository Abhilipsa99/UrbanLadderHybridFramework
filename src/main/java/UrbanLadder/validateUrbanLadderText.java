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

public class validateUrbanLadderText extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void validateText() throws InterruptedException  {
		
		LandingPage l = new LandingPage(driver);
		/*Thread.sleep(1000L);
		l.closePopUp().click();*/
		log.error("An error occured : Unable to get the expected text");
		Assert.assertEquals(l.getTitle().getText(), "Explore Our Furniture Range1");
				
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}

}
