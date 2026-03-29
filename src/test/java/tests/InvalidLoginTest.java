package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void inValidLogin()
    {
        LoginPage page=new LoginPage(driver);
        page.openLoginPage();
        page.enterUserName("wrongUserName");
        page.enterPassword("wrongPassword");
        page.clickLogin();
        String actualMessage=page.getMessage();
        Assert.assertTrue(actualMessage.contains("Your username is invalid!"),"the erro message u have provided is not displayed");
    }


}
