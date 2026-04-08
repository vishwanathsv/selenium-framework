package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void inValidLogin() {
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();

        page.login("wrongUserName", "wrongPassword");

        String actualMessage = page.getMessage();

        Assert.assertTrue(
                actualMessage.contains("Username and password do not match"),
                "Error message is not displayed"
        );
    }


}
