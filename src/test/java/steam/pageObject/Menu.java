package steam.pageObject;

import framework.WorkWithLocales;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class Menu extends BaseSteamPage {
    private static String menuItemTemplate = "//a[@class='pulldown_desktop' and contains(text(), '%s')]";
    private static String subMenuItemTemplate = "//a[@class='popup_menu_item' and contains(text(), '%s')]";
    private static Label lblMainMenu = new Label(By.xpath("//div[@class='store_nav']"), "menu locator");
    private WorkWithLocales locales = new WorkWithLocales();
    private Button btnMenuItem = new Button(By.xpath(String.format(menuItemTemplate, locales.getLoc("menuItem"))), "Categories button in main menu");
    private Button btnSubmenuItem = new Button(By.xpath(String.format(subMenuItemTemplate, locales.getLoc("subMenuItem"))), "Actions button in main menu");

    protected Menu() {
        super(By.xpath(lblMainMenu.getLocator()), "Main menu");
    }

    public void navigateMenu() {
        btnMenuItem.moveToElement();
        btnSubmenuItem.moveToElementAndClick();
    }
}