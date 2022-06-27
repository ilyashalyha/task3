package frame.elements;

import frame.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static frame.BaseTest.browser;

public class BaseElement extends Browser {

    protected By locator;
    protected String name;
    public Actions actions = new Actions(getDriver());

    public BaseElement(By loc, String nameOf) {
        locator = loc;
        name = nameOf;
    }

    public BaseElement(String value) {
        findElementByStringFormat(value);
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


    public WebElement findElementByStringFormat(String value) {
        return browser.getDriver().findElement(By.xpath(String.format(getLocator(), value)));
    }

    public void moveToElement(String value) {
        actions.moveToElement(findElementByStringFormat(value)).pause(Duration.ofMillis(500)).build().perform();
    }

    public void moveToElementAndClick(String value) {
        actions.moveToElement(findElementByStringFormat(value)).click().build().perform();
    }

    public void moveToElementByJS(String value) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", findElementByStringFormat(value));
    }

    public void waitForElement() {
        actions.pause(Duration.ofMillis(1000)).build().perform();
    }

    public List<WebElement> findElements() {
        return driver.findElements(By.xpath(getLocator()));
    }

    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    public String getLocator() {
        String text = String.valueOf(locator);
        return cutLocatorType(text);
    }

    public String cutLocatorType(String locator) {
        StringBuilder builder = new StringBuilder(locator);
        int firstPart = builder.indexOf(" ");
        return builder.substring(firstPart);
    }
}