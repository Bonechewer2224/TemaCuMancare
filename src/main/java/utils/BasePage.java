package utils;

import pages.*;

public class BasePage extends BaseTest{

    public NavigationMenuPage navPage = new NavigationMenuPage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);
    public ProductPage productPage = new ProductPage(driver);
    public CartPage cartPage = new CartPage(driver);
    public CheckoutPage checkoutPage = new CheckoutPage(driver);
    public BlogPage blogPage = new BlogPage(driver);


}
