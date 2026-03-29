package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InventoryPage {

    WebDriver driver;
    //xpath
    By productTitle = By.className("title");
    By menuButton = By.id("react-burger-menu-btn");
    By products = By.xpath("//span[text()='Products']");
    By productTitles = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");
    By sortDropdown = By.className("product_sort_container");

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

    public void sortBy(String option) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }


    //verification methods
    public boolean isProductsDisplayed() {
        return driver.findElement(products).isDisplayed();
    }

    public boolean areAllProductsValid() {
        List<WebElement> names = driver.findElements(productTitles);
        List<WebElement> prices = driver.findElements(productPrices);
        return !names.isEmpty() && !prices.isEmpty() && names.size() == prices.size();
    }

    public boolean isSortedByPriceAsc() {
        List<Double> actual = driver.findElements(productPrices).stream().map(e -> Double.parseDouble(e.getText().replace("$", ""))).toList();
        List<Double> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);
        return actual.equals(sorted);

    }

}

