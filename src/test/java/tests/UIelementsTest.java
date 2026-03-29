package tests;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;

public class UIelementsTest extends BaseTest {
    @Test
    public void verifyUIElementsPresence()
    {
        LoginPage page=new LoginPage(driver);
        page.openLoginPage();
        page.login("standard_user","secret_sauce");
        InventoryPage inventory=new InventoryPage(driver);
        Assert.assertTrue(inventory.isProductsDisplayed(),"Product not displayed");

    }
}
