package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import static org.testng.Assert.assertEquals;

public class ProductPage extends SeleniumWrappers {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[class='single_add_to_cart_button button alt']") public WebElement addToCartButton;
    @FindBy(css = "div[class='woocommerce-message']") public WebElement confirmationMessage;

    public void verifyConfirmationMessage() {
        waitForElementToBeDisplayed(confirmationMessage);
        String text = confirmationMessage.getText();
        assertEquals(text, "View cart\n" + "“Rold Gold Tiny Twists Pretzels” has been added to your cart.");
    }
}
