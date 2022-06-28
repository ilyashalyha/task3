package steam.pageObject;

import framework.WorkWithLocales;
import framework.elements.Label;
import framework.elements.StringFormat;
import org.openqa.selenium.By;

public class Menu extends BaseSteamPage {
    private static StringFormat menuItemLocator = new StringFormat(By.xpath("//a[@class='pulldown_desktop' and contains(text(), '%s')]"), "template of menu point locator");
    private static StringFormat subMenuItemLocator = new StringFormat(By.xpath("//a[@class='popup_menu_item' and contains(text(), '%s')]"), "template of submenu point locator");
    private static Label mainMenu = new Label(By.xpath("//div[@class='store_nav']"), "menu locator");
    private WorkWithLocales locales = new WorkWithLocales();

    protected Menu() {
        super(By.xpath(mainMenu.getLocator()), "Main menu");
    }

    public void navigateMenu() {
        menuItemLocator.moveToElement(locales.getLoc("menuItem"));
        subMenuItemLocator.moveToElementAndClick(locales.getLoc("subMenuItem"));
    }
}
