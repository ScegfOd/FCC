package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeDashboard {
	private String completeXPath = "//*[@value='complete']";
	private String readyXPath = "//*[@value='ready']";
	private WebDriver driver;

	public EmployeeDashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void completeTopOrder() {
		driver.findElement( By.xpath( completeXPath )).click();
	}

	public void readyTopOrder() {
		driver.findElement( By.xpath( readyXPath )).click();
	}

	public int countCompleteButtons() {
		return driver.findElements( By.xpath( completeXPath )).size();
	}

	public int countReadyButtons() {
		return driver.findElements( By.xpath( readyXPath )).size();
	}
}
