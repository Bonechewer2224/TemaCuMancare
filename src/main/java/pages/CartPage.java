package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;
import utils.Log;
import utils.ReadProperties;
import utils.SeleniumWrappers;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage extends SeleniumWrappers {
    public WebDriver driver;
    public String price = ReadProperties.config.getProperty("amount");
    public String coupon = ReadProperties.config.getProperty("discount");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.quantity-button:nth-child(4)") public WebElement plusButton;
    @FindBy(css = "span[class='woocommerce-Price-amount amount']") public WebElement totalAmount;
    @FindBy(name = "update_cart") public WebElement updateButton;
    @FindBy(css = "li[class='woocommerce-order-overview__order order']>strong") public WebElement orderNumber;
    @FindBy(id = "coupon_code") public WebElement couponField;
    @FindBy(css = "button[value='Apply coupon']") public WebElement applyCouponButton;
    @FindBy(css = "tr[class='cart-discount coupon-keyfood31122021']") public WebElement discountApplied;

    public void verifyTotalPrice(){
        try{
            Thread.sleep(2000);
            String total = totalAmount.getText();
            assertEquals(total, price);
        }catch (Exception e) {
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    public void applyDiscount(){
        sendKeys(couponField,coupon);
        click(applyCouponButton);
    }

    public void verifyTotalPriceAfterDiscount(){
        try{
            Thread.sleep(3000);
            //waitForElementToBeDisplayed(discountApplied);
            String total = totalAmount.getText();
            assertEquals(total, Integer.valueOf(total)/2);
        }catch (Exception e) {
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }


}
