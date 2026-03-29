package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By message=By.id("flash");
    By logOutButton=By.cssSelector("a[href='/logout']");

    public void enterUserName(String user)
    {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin()
    {
        driver.findElement(loginButton).click();
    }

    public void clickLogOut(){
        driver.findElement(logOutButton).click();
    }

    public void login(String username,String password)
    {
        this.enterUserName(username);
        this.enterPassword(password);
        this.clickLogin();

    }
    public void openLoginPage()
    {
        driver.get("https://www.saucedemo.com");

    }
    public String getMessage()
    {
        return driver.findElement(message).getText();
    }


}
