package frame;

import org.openqa.selenium.By;
import org.testng.Assert;

import static frame.Browser.driver;

public class BaseForm extends BaseEntity{

    public void checkOpenedPageByTitle(String title) {
        String titleLocator = "//h2[@class='pageheader']";
        Assert.assertEquals(driver.findElement(By.xpath(titleLocator)).getText(), title);
    }
}
