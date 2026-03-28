package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By username=By.id("username");
    By password=By.id("password");
    By loginButton=By.cssSelector("button[type='submit']");
    By message=By.id("flash");
    By logOutButton=By.cssSelector("a[href='/logout']");
    By logoutMessage=By.id("flash");

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
    public String getMessage()
    {
        return driver.findElement(message).getText();
    }


}
