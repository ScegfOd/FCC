package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.EmployeeDashboard;
import poms.EmployeeLogin;

public class EmployeeDashboardGlue {
	WebDriver driver;
	EmployeeLogin EL;
	EmployeeDashboard ED;
	int prevCompleteButtonSize;
	int prevReadyButtonSize;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		EL = new EmployeeLogin(driver);
		ED = new EmployeeDashboard(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Given("That I have logged in as an employee")
	public void that_i_have_logged_in_as_an_employee() {
		driver.get("http://localhost:9000/fcc.html");
		EL.login("empl13", "password1");
	}

	@When("I enter click on the topmost complete button")
	public void i_enter_click_on_the_topmost_complete_button() {
		prevCompleteButtonSize = ED.countCompleteButtons();
		ED.completeTopOrder();
	}

	@Then("I verify that there is one fewer order listed")
	public void i_verify_that_there_is_one_fewer_order_listed() {
		assert prevCompleteButtonSize - 1 == ED.countCompleteButtons();
	}

	@When("I enter click on the topmost ready button")
	public void i_enter_click_on_the_topmost_ready_button() {
		prevReadyButtonSize = ED.countReadyButtons();
		ED.readyTopOrder();
	}

	@Then("I verify that there is one more order marked ready for pickup")
	public void i_verify_that_there_is_one_more_order_marked_ready_for_pickup() {
		assert prevCompleteButtonSize - 1 == ED.countReadyButtons();
	}
}
