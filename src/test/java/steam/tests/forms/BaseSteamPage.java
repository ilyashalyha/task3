package steam.tests.forms;


import frame.BaseForm;
import frame.Browser;

import java.time.Duration;


public class BaseSteamPage extends BaseForm {


    private static String menuItemLocator = "//a[@class='pulldown_desktop' and contains(text(), '%s')]";
    private static String subMenuItemLocator = "//a[@class='popup_menu_item' and contains(text(), '%s')]";



    public void navigateMenu(String menuItem, String subMenuItem) {

        moveToElement(menuItemLocator, menuItem);
        moveToElementAndClick(subMenuItemLocator, subMenuItem);
    }



}
