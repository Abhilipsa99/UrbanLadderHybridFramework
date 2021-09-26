package UrbanLadder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class LinksInHomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void CountLinks() {
		System.out.println(driver.findElements(By.tagName("a")).size());
		log.info(driver.findElements(By.tagName("a")).size());
	}
	
	@Test
	public void CustomerStories() {
		
		LandingPage l = new LandingPage(driver);
		l.getCustomerStories().click();
		
		LandingPage2 lp = new LandingPage2(driver);
		String email = prop.getProperty("subscribeEmail");
		lp.Email().sendKeys(email);
		lp.subscribe().click();
		/*String text = lp.verifyText().getText();
		
		Assert.assertEquals(text, "THANKS FOR SUBSCRIBING");*/
		
		log.info("Subscribed Successfully");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed successfully");
	}

}
