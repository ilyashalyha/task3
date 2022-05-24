package steam.tests.forms;

import frame.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static frame.Browser.driver;

public class Menu extends BaseForm {

    private String menuItemLocator = "//a[@class='pulldown_desktop' and contains(text(), '%s')]";
    private String subMenuItemLocator = "//a[@class='popup_menu_item' and contains(text(), '%s')]";

    public void navigateMenu(String menuItem, String subMenuItem) {
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath(String.format(menuItemLocator, menuItem))).click();
        actions.moveToElement(driver.findElement(By.xpath(String.format(menuItemLocator, menuItem)))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath(String.format(subMenuItemLocator, subMenuItem)))).click().build().perform();
    }
}
