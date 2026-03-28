package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{


    @Test
    public void logIn()
    {
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage page=new LoginPage(driver);
        page.enterUserName("tomsmith");
        page.enterPassword("SuperSecretPassword!");
        page.clickLogin();
    }

}
