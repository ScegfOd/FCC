package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerDashboard {
	private String cancelXPath = "//*[@value='cancel']";
	private WebDriver driver;

	public ManagerDashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void cancelTopOrder() {
		driver.findElement( By.xpath( cancelXPath )).click();
	}

	public int countCancelButtons() {
		return driver.findElements( By.xpath( cancelXPath )).size();
	}
}
