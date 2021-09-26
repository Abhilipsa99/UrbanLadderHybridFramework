package UrbanLadder;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.cashBackPage;
import resources.base;

public class jioMartCashback extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
		
	}
	
	@Test
	public void jioCashback() {
		
		LandingPage l = new LandingPage(driver);
		l.getCashBackDetails().click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		cashBackPage cb = new cashBackPage(driver);
		System.out.println("Moved to child window successfully");
		log.info("Moved to child window successfully");
		
		log.error("Getting error : Unable to get the expected text");
		Assert.assertEquals(cb.getPageText().getText(), "Terms and Conditions For Jio Mart Cash Back");
		//log.error("Unable to get the expected text");
		
		driver.switchTo().window(parentId);
		System.out.println("Switched back to parent window");
		log.info("Switched back to parent window");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed successfully");
	}

}
