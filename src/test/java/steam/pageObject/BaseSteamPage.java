package steam.pageObject;

import framework.BaseForm;
import org.openqa.selenium.By;

public class BaseSteamPage extends BaseForm {

    protected BaseSteamPage(By locator, String formTitle) {
        super(locator, formTitle);
    }

}
