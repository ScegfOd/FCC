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

public class EmployeeLoginGlue {
	WebDriver driver;
	EmployeeLogin EL;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		EL = new EmployeeLogin(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}


	@Given("That I am on the login page")
	public void that_i_am_on_the_login_page() {
		driver.get("http://localhost:9000/fcc.html");
	}

	@When("I enter admin22 for my username and password1 as my password and press the login button")
	public void i_enter_admin22_for_my_username_and_password1_as_my_password_and_press_the_login_button() {
		EL.login("admin22", "password1");
	}

	@Then("I verify that the url of the page contains fccm.html")
	public void i_verify_that_the_url_of_the_page_contains_fccm_html() {
		String url = driver.getCurrentUrl();
		assert "fccm.html".equals(url.substring(url.length()-9));
	}

	@When("I enter admin87 for my username and password1 as my password and press the login button")
	public void i_enter_admin87_for_my_username_and_password1_as_my_password_and_press_the_login_button() {
		EL.login("admin87", "password1");
	}

	@When("I enter admin22 for my username and oops as my password and press the login button")
	public void i_enter_admin22_for_my_username_and_oops_as_my_password_and_press_the_login_button() {
		EL.login("admin22", "oops");
	}

	@Then("I verify that the url of the page contains fcc.html")
	public void i_verify_that_the_url_of_the_page_contains_fcc_html() {
		String url = driver.getCurrentUrl();
		assert "fcc.html".equals(url.substring(url.length()-8));
	}

	@When("I enter empl13 for my username and password1 as my password and press the login button")
	public void i_enter_empl13_for_my_username_and_password1_as_my_password_and_press_the_login_button() {
		EL.login("empl13", "password1");
	}

	@Then("I verify that the url of the page contains fcce.html")
	public void i_verify_that_the_url_of_the_page_contains_fcce_html() {
		String url = driver.getCurrentUrl();
		assert "fcce.html".equals(url.substring(url.length()-9));
	}

	@When("I enter empl44 for my username and password1 as my password and press the login button")
	public void i_enter_empl44_for_my_username_and_password1_as_my_password_and_press_the_login_button() {
		EL.login("empl44", "password1");
	}

	@When("I enter empl13 for my username and oops as my password and press the login button")
	public void i_enter_empl13_for_my_username_and_oops_as_my_password_and_press_the_login_button() {
		EL.login("empl13", "oops");
	}

	@When("I enter dknight84@att.net for my username and password as my password and press the login button")
	public void i_enter_dknight84_att_net_for_my_username_and_password_as_my_password_and_press_the_login_button() {
		EL.login("dknight84@att.net", "password");
	}

	@When("I enter dknight84@att.net for my username and oops as my password and press the login button")
	public void i_enter_dknight84_att_net_for_my_username_and_oops_as_my_password_and_press_the_login_button() {
		EL.login("dknight84@att.net", "oops");
	}
}
