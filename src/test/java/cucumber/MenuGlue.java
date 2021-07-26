package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.Checkout;
import poms.EmployeeLogin;
import poms.ManagerDashboard;
import poms.Menu;

public class MenuGlue {
	WebDriver driver;
	Checkout checkout;
	Menu menu;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		checkout = new Checkout(driver);
		menu = new Menu(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("That I am on the menu page")
	public void that_i_am_on_the_menu_page() {
		driver.get("http://localhost:9000/Menu.html");
	}

	@When("I enter click on an add to cart button")
	public void i_enter_click_on_an_add_to_cart_button() {
		menu.orderFirstItem();
	}

	@When("I click the cart button")
	public void i_click_the_cart_button() {
		menu.clickCart();
	}

	@When("I enter valid credit card information")
	public void i_enter_valid_credit_card_information() {
		checkout.enterValidCreditCardInfo("1234123412341234", "123", "0599");
	}

	@When("I click checkout")
	public void i_click_checkout() {
		checkout.clickCheckout();
	}

	@Then("I verify that I get to the status page")
	public void i_verify_that_i_get_to_the_status_page() {
		String url = driver.getCurrentUrl();
		assert "status.html".equals(url.substring(url.length()-11));
	}
}
