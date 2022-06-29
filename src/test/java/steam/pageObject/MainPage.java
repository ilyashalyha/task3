package steam.pageObject;

import framework.WorkWithLocales;
import framework.elements.Dropdown;
import framework.elements.Label;
import framework.elements.ListPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseSteamPage {
    private static Label lblMainPageLocator = new Label(By.xpath("//div[@class='promo_link home_header_textimage_ctn']"), "Main page locator");
    private ListPoint lptLocaleList = new ListPoint(By.xpath("//a[@class='popup_menu_item tight']"), "locale list locator");
    private String localeLocator = "//a[contains(text(), '%s')]";
    private Dropdown drdLocaleList = new Dropdown(By.xpath("//span[@id='language_pulldown']"), "locale list dropdown");
    private WorkWithLocales locales = new WorkWithLocales();
    private ListPoint lptLocalePoint;

    public MainPage() {
        super(By.xpath(lblMainPageLocator.getLocator()), "Main page");
    }

    public void setLocale(String locCode) {
        locales.setUpLocale(locCode);
        drdLocaleList.click();
        try {
            boolean res = checkLocale(locales.getLoc("localValue"));
            if (!res) {
                drdLocaleList.clickViaJS();
            } else {
                lptLocalePoint = new ListPoint(By.xpath(String.format(localeLocator, locales.getLoc("localValue"))), "locale point in multiselect");
                lptLocalePoint.click();
            }
        } catch (NoSuchElementException | NullPointerException e) {
            drdLocaleList.click();
        }
    }

    public boolean checkLocale(String localeName) {
        List<WebElement> allLocales = lptLocaleList.findElements();
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
