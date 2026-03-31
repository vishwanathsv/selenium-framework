package tests.products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class ProductsTestCase extends BaseTest {

    InventoryPage inventory;

    @BeforeMethod
    public void pageSetup() {
        // Initialize InventoryPage AFTER login
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

    @Test
    public void verifyProductDetails() {
        Assert.assertTrue(inventory.areAllProductsValid(), "Invalid product details.");
    }

    @Test
    public void verifySortByNameAscending() {
        inventory.sortBy("Price (low to high)");
        Assert.assertTrue(inventory.isSortedByPriceAsc());
    }

    @Test
    public void verifyAddToCart() {
        inventory.addFirstProductToCart();
        Assert.assertEquals(inventory.getCartCount(), 1);
    }

    @Test
    public void verifyRemoveFromCart() {
        inventory.removeFirstProduct();
        Assert.assertEquals(inventory.getCartCount(), 0);
    }

    @Test
    public void verifyCartNavigation() {
        inventory.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Test
    public void verifyProductNavigation() {
        inventory.openFirstProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item"));
    }

    @Test
    public void verifySortByNameAZ() {
        inventory.sortBy("Name (A to Z)");
        Assert.assertTrue(inventory.isSortedByNameAsc());
    }

    @Test
    public void verifySortByNameZA() {
        inventory.sortBy("Name (Z to A)");
        Assert.assertTrue(inventory.isSortedByNameDesc());
    }


}
