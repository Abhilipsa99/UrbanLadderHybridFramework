package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cashBackPage {
	
	public WebDriver driver;
	public cashBackPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By jioText = By.cssSelector("#page_content > h1");
	
	public WebElement getPageText() {
		return driver.findElement(jioText);
	}
	
	

}
