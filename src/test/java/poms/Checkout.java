package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	@FindBy(id = "card")
	public WebElement cardBox;
	@FindBy(id = "cvv")
	public WebElement securityBox;
	@FindBy(xpath = "//*[@name='date']")
	public WebElement expiryBox;
	@FindBy(id = "checkout")
	public WebElement checkoutButton;

	public Checkout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterValidCreditCardInfo(String cardnumber, String cvv, String date) {
		this.cardBox.sendKeys(cardnumber);
		this.securityBox.sendKeys(cvv);
		this.expiryBox.sendKeys(date);
	}

	public void clickCheckout() {
		this.checkoutButton.click();
	}
}
