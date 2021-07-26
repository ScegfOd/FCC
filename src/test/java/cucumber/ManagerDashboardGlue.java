package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import poms.EmployeeLogin;
import poms.ManagerDashboard;

public class ManagerDashboardGlue {
	WebDriver driver;
	EmployeeLogin EL;
	ManagerDashboard MD;
	int prevCancelButtonSize;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		EL = new EmployeeLogin(driver);
		MD = new ManagerDashboard(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
	@Given("That I have logged in as a manager")
	public void that_i_have_logged_in_as_a_manager() {
		driver.get("http://localhost:9000/fcc.html");
		EL.login("admin87", "password1");
	}

	@When("I enter click on the topmost cancel button")
	public void i_enter_click_on_the_topmost_cancel_button() {
		prevCancelButtonSize = MD.countCancelButtons();
		MD.cancelTopOrder();
	}

	@Then("I verify that there is fewer cancel button")
	public void i_verify_that_there_is_fewer_cancel_button() {
		assert prevCancelButtonSize - 1 == MD.countCancelButtons();
	}
}
