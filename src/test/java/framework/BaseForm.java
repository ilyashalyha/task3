package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.Date;

public class BaseForm extends Browser{
    protected By titleLocator;
    protected String title;
    protected String name;

    protected BaseForm(final By locator, final String title) {
        init(locator, title);
        assertIsOpen();
    }

    public void assertIsOpen() {
        long before = new Date().getTime();
        Label elem = new Label(titleLocator, title);
        try {
            elem.waitForIsElementPresent();
            long openTime = new Date().getTime() - before;
            System.out.println(String.format("Form '%1$s' appears", title) + String.format(" in %smsec",openTime));

        } catch (Throwable e) {
            System.err.println(title);
        }
    }

    private void init(final By locator, final String formTitle) {
        titleLocator = locator;
        title = formTitle;
        name = String.format("Form '%1$s' appears" + " '%1$s'", this.title);
    }

    public void checkOpenedPageByTitle(String title) {
        String titleLocator = "//h2[@class='pageheader']";
        Assert.assertEquals(driver.findElement(By.xpath(titleLocator)).getText(), title);
    }

    public void checkOpenedPageByText(String value, String res) {
        Assert.assertEquals(value, res);
    }

    public void assertIsOpenedPage(String locator) {
        Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed());
    }
}