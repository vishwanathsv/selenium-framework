package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LogOutTest extends BaseTest {
    @Test
    public void logOutTest() {
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();
        page.login("standard_user", "secret_sauce");
        InventoryPage invent = new InventoryPage(driver);
        invent.clickMenu();
        invent.clickButtonByName("Logout");
        Assert.assertTrue(driver.getCurrentUrl().contains("sauce"), "Doesn't contain the expected path");
    }

}

