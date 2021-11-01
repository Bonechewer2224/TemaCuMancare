package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.AssertJUnit.assertEquals;

public class BlogPage extends SeleniumWrappers {
    public WebDriver driver;
    public String nrofblogs = ReadProperties.config.getProperty("blognr");
    public String firstname = ReadProperties.config.getProperty("firstname");
    public String email = ReadProperties.config.getProperty("email");
    public String comment = ReadProperties.config.getProperty("text");

    @FindBy (id ="comment") public WebElement commentField;
    @FindBy (id ="author") public WebElement authorField;
    @FindBy (id ="email") public WebElement mailField;
    @FindBy (id = "submit") public WebElement submitButton;
    @FindBy (css = "img[class='avatar'][alt='Gogu']") public WebElement myAvatar;
    @FindBy (css = "article[class*='post type-post status-publish format-standard has-post-thumbnail']") public List<WebElement> blog;

        public BlogPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void checkNumberOfBlogPosts() {
            assertEquals(blog.size(), Integer.parseInt(nrofblogs));
            System.out.println("Number of blogs= " + blog.size());
        }

        public void addCommentAndVerify() throws InterruptedException {
                sendKeys(commentField, comment+ThreadLocalRandom.current().nextInt());
                sendKeys(authorField,firstname);
                sendKeys(mailField,email);
                click(submitButton);
                waitForElementToBeDisplayed(myAvatar);
                Thread.sleep(11000);
        }
}

