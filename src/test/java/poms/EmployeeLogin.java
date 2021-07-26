package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeLogin {
	@FindBy(id = "id")
	public WebElement usernameBox;
	@FindBy(id = "password")
	public WebElement passwordBox;
	@FindBy(id = "submit")
	public WebElement loginButton;

	public EmployeeLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		this.usernameBox.sendKeys(username);
		this.passwordBox.sendKeys(password);
		this.loginButton.click();
	}

}
