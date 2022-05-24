package frame;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static frame.BaseEntity.browser;


public class BaseElement {

    protected WebElement element;

    public void click() {

        browser.getDriver().navigate().to(String.valueOf(element));
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor)browser.getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
        }
        element.click();
    }


}