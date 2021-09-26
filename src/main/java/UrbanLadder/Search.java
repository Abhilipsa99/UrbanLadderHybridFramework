package UrbanLadder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.ExcelReader;

import PageObjects.LandingPage;
import PageObjects.LandingPage2;
import resources.base;

public class Search extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		log.info("Driver is initialized");
	}
	
	@Test
	public void Search() throws InterruptedException, IOException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Navigated to Home Page Successfully");
		LandingPage l = new LandingPage(driver);
		l.Search().click();
		//prop = new Properties();
		//FileInputStream fis = new FileInputStream(".\\data.properties");
		//prop.load(fis);
		String searchItem = prop.getProperty("searchItem");
		l.Search().sendKeys(searchItem);
		//Thread.sleep(1000L);
		//l.closePopUp().click();
		l.Search().sendKeys(Keys.DOWN);
		l.Search().sendKeys(Keys.DOWN);
		l.Search().sendKeys(Keys.ENTER);
		
		LandingPage2 lp2 = new LandingPage2(driver);
		Thread.sleep(1000L);
		String title = lp2.SearchText().getText();
		Assert.assertTrue(title.contains(searchItem));
		System.out.println("The search page for the item to be searched loaded successfully");
		
		log.info("The search page for the item to be searched loaded successfully");
		
		l.closePopUp().click();
		lp2.SelectItem().click();
		lp2.SelectCategory().click();
		
		log.info("Successfully displayed the selected category page");
		
	}
	
	@Test(dataProvider="getData")
	public void getSearchItem(String item) throws InterruptedException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Nagivated to Home Page of Urban Ladder");
		LandingPage l = new LandingPage(driver);
		l.Search().click();
		l.Search().sendKeys(item);
		l.Search().sendKeys(Keys.ENTER);
		LandingPage2 lp2 = new LandingPage2(driver);
		Thread.sleep(1000L);
		String title = lp2.SearchText().getText();
		Assert.assertTrue(title.contains(item));
		log.info("Successfully Navigated to "+item+" page");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][]data = null;
		try {
			data= ExcelReader.readExcel();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}

	
	

}
