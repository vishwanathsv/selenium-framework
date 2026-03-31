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
    By productDescriptions = By.className("inventory_item_desc");
    By productImages = By.className("inventory_item_img");
    By sortDropdown = By.className("product_sort_container");
    By addToCartButtons = By.xpath("//button[text()='Add to cart']");
    By removeButtons = By.xpath("//button[text()='Remove']");
    By addBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    By removeBackpack = By.id("remove-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");


    //constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //getter methods
    public String getPageTitle() {
        return driver.findElement(productTitle).getText();
    }

    public int getCartCount() {
        List<WebElement> badge = driver.findElements(cartBadge);
        if (badge.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badge.get(0).getText());
    }

    public int getProductCount() {
        return driver.findElements(productTitles).size();
    }

    //action methods
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    public void removeFirstProduct() {
        this.addFirstProductToCart();
        this.openCart();
        driver.findElements(removeButtons).get(0).click();
    }

    public void clickButtonByName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + name + "']"))).click();
    }

    public void sortBy(String option) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void openFirstProduct() {
        driver.findElements(productTitles).get(0).click();
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

    public boolean isSortedByNameAsc() {
        List<String> actual = driver.findElements(productTitles).stream().map(e -> e.getText()).toList();
        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);
        return actual.equals(sorted);
    }

    public boolean isSortedByNameDesc() {
        List<String> actual = driver.findElements(productTitles).stream().map(e -> e.getText()).toList();
        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted, Collections.reverseOrder());
        return actual.equals(sorted);
    }

}

