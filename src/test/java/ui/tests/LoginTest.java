package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void logIn() {
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();
        page.enterUserName("standard_user");
        page.enterPassword("secret_sauce");
        page.clickLogin();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory"), "url doesn't have expected path");


    }
}