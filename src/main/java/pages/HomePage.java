package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;
import java.util.List;
import java.util.Random;

public class HomePage extends SeleniumWrappers {
    public WebDriver driver;
    public String product1 = ReadProperties.config.getProperty("item1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dgwt-wcas-search-input-1") public WebElement searchField;
    @FindBy(css = "a[class='dgwt-wcas-suggestion dgwt-wcas-suggestion-product']") public WebElement firstSearchResult;
    @FindBy(css = "i[class=klbth-icon-snowflake]") public WebElement frozenFoodsCategory;
    @FindBy(css = "i[class=klbth-icon-cup]") public WebElement beveragesCategory;
    @FindBy(css = "a[title='Coca-Cola – 2 L Bottle']") public WebElement colaBottle;

    public void searchProduct() {
        sendKeys(searchField,product1);
    }

    public void findCola(){
        click(beveragesCategory);
        click(colaBottle);
    }

    public void addFrozenFood(){
        click(frozenFoodsCategory);
        List<WebElement> myElements = driver.findElements(By.cssSelector("div[class*='product type-product post']"));
        Random r = new Random();
        int randomValue = r.nextInt(myElements.size());
        click(myElements.get(randomValue));
    }


}
