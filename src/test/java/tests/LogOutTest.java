package tests;
import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LogOutTest extends BaseTest {
@Test
    public void logOutTest(){
    driver.get("https://the-internet.herokuapp.com/login");
     LoginPage page =new LoginPage(driver);
     page.clickLogin();
     page.enterUserName("tomsmith");
     page.enterPassword("SuperSecretPassword!");
     page.clickLogin();

     page.clickLogOut();
     String msg= page.getMessage();
     System.out.println("message is :"+msg);
     Assert.assertTrue(msg.contains("You logged out of the secure area!"),"The msg u have provided is incorrect !");

}

}

