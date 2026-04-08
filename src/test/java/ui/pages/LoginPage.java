package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By message = By.cssSelector("h3[data-test='error']");
    By logOutButton = By.cssSelector("a[href='/logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }

    public void login(String username, String password) {
        this.enterUserName(username);
        this.enterPassword(password);
        this.clickLogin();

    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com");

    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(message)
        ).getText();
    }


}
