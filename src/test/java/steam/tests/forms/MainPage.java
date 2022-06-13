package steam.tests.forms;

import frame.elements.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseSteamPage {
    private String localeList = "//a[@class='popup_menu_item tight']";
    private String localeLocator = "//a[contains(text(), '%s')]";
    private Dropdown drdLocaleList = new Dropdown(By.xpath("//span[@id='language_pulldown']"), "locale list dropdown");

    public void setLocale(String locCode) {
        setUpLocale(locCode);
        drdLocaleList.click();

        try {
            boolean res = checkLocale(getLoc("localValue"));
            if (!res) {
                drdLocaleList.click();
            } else {
                findElementByStringFormat(localeLocator, getLoc("localValue")).click();
            }
        } catch (NoSuchElementException e) {
            drdLocaleList.click();
        }
    }

    public boolean checkLocale(String localeName) {
        List<WebElement> allLocales = findElements(localeList);
        for (WebElement elements :
                allLocales) {
            String localeNameValuesList = elements.getText();
            return !localeNameValuesList.contains(localeName);
        } return true;
    }
}
