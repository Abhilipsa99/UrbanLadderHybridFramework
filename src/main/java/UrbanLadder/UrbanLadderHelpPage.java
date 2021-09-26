package UrbanLadder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class UrbanLadderHelpPage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized and navigated to the home page successfully");
	}
	
	@Test
	public void Help() {
		
		LandingPage l =new LandingPage(driver);
		l.getHelp().click();
		String problem = prop.getProperty("help");
		l.Problem().sendKeys(problem);
		l.Problem().sendKeys(Keys.DOWN);
		l.Problem().sendKeys(Keys.ENTER);
		
		LandingPage2 lp = new LandingPage2(driver);
		String getText = lp.validateHelpText().getText();
		Assert.assertTrue(getText.contains(problem));
		System.out.println("SOLUTIONS DISPLAYED");
		
		log.info("SOLUTIONS DISPLAYED For the problem");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}
	

}
