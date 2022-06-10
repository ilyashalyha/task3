package frame.elements;

import frame.BaseForm;
import org.openqa.selenium.*;

import static frame.BaseTest.browser;



public class BaseElement extends BaseForm {

    protected By locator;
    protected String name;


    public BaseElement(By loc, String nameOf) {
        locator = loc;
        name = nameOf;
    }

    public BaseElement(String locator, String value) {
        findElementByStringFormat(locator, value);
    }

    public BaseElement(By loc) {
        locator = loc;
    }


    public WebElement getElement() {
        return findElement(locator);
    }


    public void click() {
        getElement().click();
    }

    public WebElement findElement(By locator) {
        return browser.getDriver().findElement(locator);
    }

    public WebElement findElementByStringFormat(String locator, String value) {
        return browser.getDriver().findElement(By.xpath(String.format(locator, value)));
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }




}