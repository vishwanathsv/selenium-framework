package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.LoginPage;

public class NavigationTest extends BaseTest {

    @Test
    public void verifyNavigation() {
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();
        page.login("standard_user", "secret_sauce");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory"), "Url doesn't contain the expected text");
    }
}
