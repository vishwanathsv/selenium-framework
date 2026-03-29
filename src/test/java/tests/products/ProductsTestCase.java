package tests.products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class ProductsTestCase extends BaseTest {

    InventoryPage inventory;

    @BeforeTest
    public void loginSetup() {
        LoginPage page = new LoginPage(driver);
        page.openLoginPage();
        page.login("standard_user", "secret_sauce");
        inventory = new InventoryPage(driver);
    }

    @Test
    public void verifyProductPageLoads() {
        Assert.assertTrue(inventory.isProductsDisplayed(), "Products not displayed");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Current URL Doesn't contains the expected path ");
    }

    @Test
    public void verifyProductsAreListed() {
        Assert.assertTrue(inventory.getProductCount() > 0, "No Products found");
    }
}
