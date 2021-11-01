package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class E2ETest_1 extends BaseTest {

    @Test(priority = 0)
    public void login() {
        page.navPage.navigateTo(page.navPage.loginLink);
        page.loginPage.loginInApp();
    }

    @Test(priority = 1)
    public void searchProductFromHomepage() {
        page.navPage.navigateTo(page.navPage.homeLink);
        page.homePage.searchProduct();
        page.homePage.click(page.homePage.firstSearchResult);
    }

    @Test(priority = 2)
    public void addProductToCart() {
        page.productPage.click(page.productPage.addToCartButton);
        page.productPage.verifyConfirmationMessage();
    }

    @Test(priority = 3)
    public void modifyCartAndRefresh() {
        page.productPage.click(page.navPage.cartLink);
        page.cartPage.click(page.cartPage.plusButton);
        page.cartPage.click(page.cartPage.updateButton);
        page.cartPage.verifyTotalPrice();
    }

    @Test(priority = 4)
    public void addShippingDetails(){
        page.cartPage.click(page.checkoutPage.checkoutButton);
        page.checkoutPage.addShippingDetails();
    }

    @Test(priority = 5)
    public void checkoutCart() {
        page.cartPage.hoverElement(page.checkoutPage.termsCheckbox);
        page.cartPage.click(page.checkoutPage.termsCheckbox);
        page.cartPage.click(page.checkoutPage.placeOrderButton);
        page.cartPage.waitForElementToBeDisplayed(page.cartPage.orderNumber);
    }
}







