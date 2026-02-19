package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");

    public By getLoginButton() {
        return loginButton;
    }

    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logOutBtn = By.id("logout_sidebar_link");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickOnMenuBTn() {
        driver.findElement(menuBtn).click();
    }

    public void ValidateBtnlogOutIsDisplayed() {
        driver.findElement(logOutBtn).isDisplayed();
    }

    public void clickOnLogoutBTn() {
        driver.findElement(logOutBtn).click();
    }

    public void ValideteLoginBtnIsDisplayed() {
        driver.findElement(loginButton).isDisplayed();
    }
}
