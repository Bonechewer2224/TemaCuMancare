package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class NavigationMenuPage extends SeleniumWrappers {

    public WebDriver driver;

    public NavigationMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "HOME") public WebElement homeLink;
    @FindBy(linkText = "BLOG") public WebElement blogLink;
    @FindBy(css = "i[class='klbth-icon-shopping-bag']") public WebElement cartLink;
    @FindBy(id = "menu-item-1892") public WebElement loginLink;


    public void navigateTo(WebElement element){
        click(element);
    }



}
