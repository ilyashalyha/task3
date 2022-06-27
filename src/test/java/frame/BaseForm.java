package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;
import java.util.Locale;
import java.util.ResourceBundle;


public class BaseForm extends Browser{

    public ResourceBundle locBundle;

    public BaseForm(WebDriver driver) {
        Browser.driver = driver;
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

    public void setLocBundle(String locCode) {
        Locale locale = new Locale(locCode);
        locBundle = ResourceBundle.getBundle("localization/loc", locale);
    }

    public ResourceBundle getLocBundle() {
        return locBundle;
    }

    public String getLoc(String locPoint) {
        return getLocBundle().getString(locPoint);
    }

    public void setUpLocale(String locCode) {
        setLocBundle(locCode);
    }

}
