package UrbanLadder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class TrackOrder extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
	}
	
	@Test
	public void trackOrder() throws IOException {
		LandingPage l = new LandingPage(driver);
		l.getTrackDetails().click();
		
		log.info("Navigated to track order page for filling the order details");
		
		LandingPage2 lp2 = new LandingPage2(driver);
		/*prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\data.properties");
		prop.load(fis);*/
		String orderNo = prop.getProperty("orderNo");
		String phNo = prop.getProperty("phoneNum");
		lp2.getOrderNo().sendKeys(orderNo);
		lp2.getPhoneNo().sendKeys(phNo);
		lp2.Submit().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed successfully");
	}

}
