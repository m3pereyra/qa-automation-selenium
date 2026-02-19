package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;

public class InventoryTest extends base.BaseTest {

    protected WebDriverWait wait;

    private By sauceLabsBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By sauceLbsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    @Override
    public void setUp() {
        super.setUp();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifySauceLabsIsDisplayed () {
        login();

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(sauceLabsBackpackBtn)
        );

        Assertions.assertTrue(product.isDisplayed());
    }

    @Test
    public void verifyShoppingCartBadge() {
        login();

        driver.findElement(sauceLbsBikeLight).click();

        WebElement shopping_cart_badge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(shoppingCartBadge)
        );

        Assertions.assertTrue(shopping_cart_badge.isDisplayed());

    }
}
