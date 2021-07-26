package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {
	private String cancelXPath = "//*[@id='add']";
	private String hrefXPath = "//*[@href='http://localhost:9000/Checkout.html']";
	private WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}

	public void orderFirstItem() {
		driver.findElement( By.xpath( cancelXPath )).click();
	}
	
	public void clickCart() {
		driver.findElement( By.xpath( hrefXPath )).click();
	}
}
