package steam.tests.forms;

import frame.BaseForm;
import frame.elements.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;



public class MainPage extends BaseSteamPage {
    private String localeList = "//a[@class='popup_menu_item tight']";
    private String localeLocator = "//a[contains(text(), '%s')]";
    private Dropdown drdLocaleList = new Dropdown(By.xpath("//span[@id='language_pulldown']"), "locale list dropdown");




    public void setLocale(String locCode) {

        //Locale locale = new Locale(locCode);
        //ResourceBundle locBundle = ResourceBundle.getBundle("localization/loc", locale);
        drdLocaleList.click();

        //String localeName = locBundle.getString("localValue");

        try {
            boolean res = checkLocale(getLocaleValue(locCode));
            if (!res) {
                drdLocaleList.click();
            } else {
                driver.findElement(By.xpath(String.format(localeLocator, getLocaleValue(locCode)))).click();
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
