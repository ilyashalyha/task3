package steam.pageObjects;

import frame.elements.Dropdown;
import frame.elements.ListPoint;
import frame.elements.StringFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseSteamPage {
    private ListPoint localeList = new ListPoint(By.xpath("//a[@class='popup_menu_item tight']"), "locale list locator");
    private StringFormat localeLocator = new StringFormat(By.xpath("//a[contains(text(), '%s')]"), "template of locale locator");
    private Dropdown drdLocaleList = new Dropdown(By.xpath("//span[@id='language_pulldown']"), "locale list dropdown");

    public MainPage() {
        super(driver);
    }

    public void setLocale(String locCode) {
        setUpLocale(locCode);
        drdLocaleList.click();

        try {
            boolean res = checkLocale(getLoc("localValue"));
            if (!res) {
                drdLocaleList.click();
            } else {
                localeLocator.findElementByStringFormat(getLoc("localValue")).click();
            }
        } catch (NoSuchElementException e) {
            drdLocaleList.click();
        }
    }

    public boolean checkLocale(String localeName) {
        List<WebElement> allLocales = localeList.findElements();
        for (WebElement elements :
                allLocales) {
            String localeNameValuesList = elements.getText();
            return !localeNameValuesList.contains(localeName);
        } return true;
    }
}
