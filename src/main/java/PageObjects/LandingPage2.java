package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage2 {
	
	public WebDriver driver;
	public LandingPage2(WebDriver driver) {
		this.driver = driver;
	}
	
	By viewDetails = By.xpath("//*[@id=\'app-container\']/div/main/section[2]/div/a[2]/div[2]/button");
	By text = By.xpath("//*[@id=\'store-details\']/h1");
	
	By orderNo = By.xpath("//input[@id='ip_379403698']");
	By phoneNo = By.xpath("//*[@id=\"ip_394711104\"]");
	By submit = By.cssSelector("#app-container > div > main > section > form.awunb > button");
	
	By selectItem = By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]");
	By selectCategory = By.xpath("//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[4]");
	
	By searchText = By.xpath("//*[@id=\"search-results\"]/div[1]/h2");
	
	By text2 = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/span");
	
	By email = By.xpath("//input[@id='email_id']");
	By subscribe = By.xpath("//input[@value='SUBSCRIBE']");
	By text3 = By.xpath("//*[@id=\"footer\"]/div[1]/div/div");
	
	By item = By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[2]/div/a/img");
	By view = By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[2]/div/div[3]/div[2]/a[2]");
	
	By price = By.cssSelector("#buy_details_101035 > div.product-price > div.ppricesec > div.price-components > div");
	By add = By.xpath("//button[@id='add-to-cart-button']");
	
	public WebElement getStoreDetails() {
		return driver.findElement(viewDetails);
	}
	
	public WebElement getTitle() {
		return driver.findElement(text);
	}
	
	public WebElement getOrderNo( ) {
		return driver.findElement(orderNo);
	}
	
	public WebElement getPhoneNo() {
		return driver.findElement(phoneNo);
	}
	
	public WebElement Submit() {
		return driver.findElement(submit);
	}
	
	public WebElement SelectItem() {
		return driver.findElement(selectItem);
	}
	
	public WebElement SelectCategory() {
		return driver.findElement(selectCategory);
	}
	
	public WebElement SearchText() {
		return driver.findElement(searchText);
	}
	
	public WebElement validateHelpText() {
		return driver.findElement(text2);
	}
	
	public WebElement Email() {
		return driver.findElement(email);
	}
	public WebElement subscribe() {
		return driver.findElement(subscribe);
	}
	
	public WebElement Item() {
		return driver.findElement(item);
	}
	
	public WebElement viewDetails() {
		return driver.findElement(view);
	}
	
	public WebElement verifyText() {
		return driver.findElement(text3);
	}
	
	public WebElement viewPrice() {
		return driver.findElement(price);
	}
	
	public WebElement addToCart() {
		return driver.findElement(add);
	}
}
