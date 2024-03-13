package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement warningBanner;
    @FindBy(linkText = "Forgotten Password")
    private WebElement forgottenPasswordLink;
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    //Action Methods
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public String getWarningBannerText() { return warningBanner.getText(); }
    public boolean isForgottenPasswordLinkDisplayed() {
        return forgottenPasswordLink.isDisplayed();
    }
    public void clickForgottenPasswordLink() { forgottenPasswordLink.click(); }
    public String getForgottenPasswordPageURL(){ return driver.getCurrentUrl(); }
    public boolean isLogoutLinkDisplayed(){ return logoutLink.isDisplayed(); }
    public void performLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
