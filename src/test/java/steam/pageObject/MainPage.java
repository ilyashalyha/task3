package steam.pageObject;

import framework.WorkWithLocales;
import framework.elements.Dropdown;
import framework.elements.Label;
import framework.elements.ListPoint;
import framework.elements.StringFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseSteamPage {
    private static Label mainPageLocator = new Label(By.xpath("//div[@class='promo_link home_header_textimage_ctn']"), "Main page locator");
    private ListPoint localeList = new ListPoint(By.xpath("//a[@class='popup_menu_item tight']"), "locale list locator");
    private StringFormat localeLocator = new StringFormat(By.xpath("//a[contains(text(), '%s')]"), "template of locale locator");
    private Dropdown drdLocaleList = new Dropdown(By.xpath("//span[@id='language_pulldown']"), "locale list dropdown");
    private WorkWithLocales locales = new WorkWithLocales();

    public MainPage() {
        super(By.xpath(mainPageLocator.getLocator()), "Main page");
    }

    public void setLocale(String locCode) {
        locales.setUpLocale(locCode);
        drdLocaleList.click();

        try {
            boolean res = checkLocale(locales.getLoc("localValue"));
            if (!res) {
                drdLocaleList.click();
            } else {
                localeLocator.findElementByStringFormat(locales.getLoc("localValue")).click();
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

    public void navigateMenu() {
        Menu menu = new Menu();
        menu.navigateMenu();
    }
}
