package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers {
    public WebDriver driver;
    public String firstname = ReadProperties.config.getProperty("firstname");
    public String lastname = ReadProperties.config.getProperty("lastname");
    public String address = ReadProperties.config.getProperty("address");
    public String city = ReadProperties.config.getProperty("city");
    public String zipcode = ReadProperties.config.getProperty("zipcode");
    public String phone = ReadProperties.config.getProperty("phone");
    public String email = ReadProperties.config.getProperty("email");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='checkout-button button alt wc-forward']") public WebElement checkoutButton;
    @FindBy(id = "terms") public WebElement termsCheckbox;
    @FindBy(id = "place_order") public WebElement placeOrderButton;
    @FindBy(id = "billing_first_name") public WebElement firstNameField;
    @FindBy(id = "billing_last_name") public WebElement lastNameField;
    @FindBy(id = "billing_address_1") public WebElement addressField;
    @FindBy(id = "billing_city") public WebElement cityField;
    @FindBy(id = "billing_postcode") public WebElement zipcodeField;
    @FindBy(id = "billing_phone") public WebElement phoneField;
    @FindBy(id = "billing_email") public WebElement emailField;

    public void addShippingDetails(){
        sendKeys(firstNameField,firstname);
        sendKeys(lastNameField,lastname);
        sendKeys(addressField,address);
        sendKeys(cityField,city);
        sendKeys(zipcodeField,zipcode);
        sendKeys(phoneField,phone);
        sendKeys(emailField,email);
    }
}
