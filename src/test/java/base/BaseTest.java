package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();
        page.login("standard_user", "secret_sauce");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
