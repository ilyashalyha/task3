package steam.pageObjects;

import frame.BaseForm;
import frame.elements.StringFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSteamPage extends BaseForm {

    private static StringFormat menuItemLocator = new StringFormat(By.xpath("//a[@class='pulldown_desktop' and contains(text(), '%s')]"), "template of menu point locator");
    private static StringFormat subMenuItemLocator = new StringFormat(By.xpath("//a[@class='popup_menu_item' and contains(text(), '%s')]"), "template of submenu point locator");

    public BaseSteamPage(WebDriver driver) {
        super(driver);
    }

    public void navigateMenu() {
        menuItemLocator.moveToElement(getLoc("menuItem"));
        subMenuItemLocator.moveToElementAndClick(getLoc("subMenuItem"));
    }
}
