package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class E2ETest_2 extends BaseTest {

    @Test(priority = 0)
    public void addFrozenFoods() {
        page.navPage.navigateTo(page.navPage.homeLink);
        page.homePage.addFrozenFood();
        page.productPage.click(page.productPage.addToCartButton);
        page.navPage.navigateTo(page.navPage.homeLink);
        page.homePage.addFrozenFood();
        page.productPage.click(page.productPage.addToCartButton);
        page.productPage.click(page.navPage.cartLink);
    }

    @Test(priority = 1)
    public void addBeverage (){
        page.navPage.navigateTo(page.navPage.homeLink);
        page.homePage.findCola();
        page.productPage.click(page.productPage.addToCartButton);
        page.productPage.click(page.navPage.cartLink);
    }

    @Test(priority = 2)
    public void applyCoupon (){
        page.cartPage.applyDiscount();
        page.cartPage.waitForElementToBeDisplayed(page.cartPage.discountApplied);
    }

    @Test(priority = 3)
    public void addShippingDetails(){
        page.cartPage.click(page.checkoutPage.checkoutButton);
        page.checkoutPage.addShippingDetails();
    }

    @Test(priority = 5)
    public void checkoutCart() {
        page.cartPage.click(page.checkoutPage.termsCheckbox);
        page.cartPage.click(page.checkoutPage.placeOrderButton);
        page.cartPage.waitForElementToBeDisplayed(page.cartPage.orderNumber);
    }
}
