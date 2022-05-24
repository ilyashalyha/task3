package steam.tests.forms;

import frame.BaseEntity;
import frame.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static frame.Browser.driver;


public class MainPage extends BaseForm {
    private String localeList = "//a[@class='popup_menu_item tight']";
    private String localeLocator = "//a[contains(text(), '%s')]";
    private String localeListLocator = "//span[@id='language_pulldown']";


    public void setLocale(String localeName) {

        driver.findElement(By.xpath(localeListLocator)).click();

        try {
            boolean res = checkLocale(localeName);
            if (!res) {
                driver.findElement(By.xpath(localeListLocator)).click();
            } else {
                driver.findElement(By.xpath(String.format(localeLocator, localeName))).click();
            }
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath(localeListLocator)).click();
        }



    }

    public boolean checkLocale(String localeName) {
        List<WebElement> allLocales = driver.findElements(By.xpath(localeList));
        for (WebElement elements :
                allLocales) {
            String localeNameValuesList = elements.getText();
            return !localeNameValuesList.contains(localeName);
        } return true;


    }

}
