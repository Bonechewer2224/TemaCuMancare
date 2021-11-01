package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {

    public void doubleClick(WebElement element) {
        try{
            Log.info("Called the <doubleClick> on element" + element);
            waitForElementToBeDisplayed(element);
            waitForElementToBeClickable(element);
            Actions actions =  new Actions(driver);
            actions.doubleClick(element).perform();
        }catch (Exception e) {
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }


    public void hoverElement(WebElement element) {
        try{
            Log.info("Called the <hoverElement> on element" + element);
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.moveToElement(element).perform();
        }catch (Exception e) {
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    public void dragAndDropSlider(WebElement element, int xOffset, int yOffset){
        try{
            Log.info("Called the <dragAndDropSlider> on element" + element);
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.dragAndDropBy(element, xOffset, yOffset).perform();

        }catch (Exception e) {
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        try{
            Log.info("Called the <waitForElementToBeDisplayed> on element" + element);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try{
            Log.info("Called the <waitForElementToBeClickable> on element" + element);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            Log.error("Failed on <waitForElementToBeClickable>  on element" + element);
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to send key values (String) to an input or textarea field
     * First clears the element of any text
     * @param element : WebELment that receives the text input
     * @param value : The String value to be sent
     */
    public void sendKeys(WebElement element, String value) {
        try{
            Log.info("Called the <sendKeys> on element" + element);
            waitForElementToBeDisplayed(element);
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            Log.error(e.getStackTrace().toString());
            throw new TestException("The element was not present");
        }
    }

    /**
     * Method used to click an element. Makes use of method waitForElementToBeClickable(element);
     * @param element : element to be clicked on (type WebElement)
     */
    public void click(WebElement element) {
        Log.info("Called the <click> on element" + element);
        waitForElementToBeDisplayed(element);
        waitForElementToBeClickable(element);
        try {
            element.click();
        }catch(StaleElementReferenceException e) {
            Log.error("error catched StaleElementReferenceException");
            element.click();
        }catch (Exception e) {
            throw new TestException("Element was not clickable");
        }
    }


}