package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import page.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        //driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }
    @Given("I have entered a valid {string} and {string}")
    public void i_have_entered_a_valid_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();

    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
    }
    @Given("I have entered an invalid {string} and {string}")
    public void i_have_entered_an_invalid_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
    @Then("I should see a error message indicating {string}")
    public void i_should_see_a_error_message_indicating(String errorMessage) {
        Assert.assertEquals(loginPage.getWarningBannerText(), errorMessage);
    }
    @When("I click on the forgotten password link")
    public void i_click_on_the_forgotten_password_link() {
        loginPage.clickForgottenPasswordLink();
    }
    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getForgottenPasswordPageURL().contains("account/forgotten"));
    }
}
