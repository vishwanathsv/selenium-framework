package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InventoryPage {

    WebDriver driver;
    //xpath
    By productTitle = By.className("title");
    By menuButton = By.id("react-burger-menu-btn");
    By products = By.xpath("//span[text()='Products']");
    By productTitles = By.className("inventory_item_name");

    //constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //getter methods
    public String getPageTitle() {
        return driver.findElement(productTitle).getText();
    }

    public int getProductCount() {
        return driver.findElements(productTitles).size();
    }

    //action methods
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }


    public void clickButtonByName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + name + "']"))).click();
    }

    //verification methods
    public boolean isProductsDisplayed() {
        return driver.findElement(products).isDisplayed();
    }


}

