package UrbanLadder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class ViewItemDetails extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
		
	}
	
	@Test
	public void viewProductDetails() throws InterruptedException {
		
		LandingPage l = new LandingPage(driver);
		/*Thread.sleep(1000L);
		l.closePopUp().click();*/
		l.Search().click();
		String searchItem = prop.getProperty("searchItem");
		l.Search().sendKeys(searchItem);
		l.Search().sendKeys(Keys.DOWN);
		l.Search().sendKeys(Keys.DOWN);
		l.Search().sendKeys(Keys.ENTER);
		
		log.info("Landed on the page of products to be searched");
		
		LandingPage2 lp = new LandingPage2(driver);
		Actions a = new Actions(driver);
		a.moveToElement(lp.Item());
		Thread.sleep(1000L);
		l.closePopUp().click();
		Thread.sleep(1000L);
		a.moveToElement(lp.viewDetails()).click().build().perform();
		
		lp.addToCart().click();
		log.info("Successfully added the item to the cart for future use");
		
		//System.out.println("The price of the item is : "+lp.viewPrice().getText());
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}
	

}
