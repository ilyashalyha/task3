package steam.tests.forms;

import frame.BaseForm;
import frame.elements.Button;
import frame.elements.InfoField;
import org.openqa.selenium.By;

import static frame.Browser.driver;

public class GamePage extends BaseSteamPage {


    private InfoField fldDiscount = new InfoField(By.xpath("//div[@class='discount_block game_purchase_discount']/div[@class='discount_pct']"));
    private Button btnInstallSteam = new Button(By.xpath("//a[@class='header_installsteam_btn_content']"), "install Steam button");

    public void checkGamePage(String value) {
        checkOpenedPageByText(fldDiscount.getElement().getText().substring(1, 3), value);
    }

    public void clickInstallSteamButton() {
        btnInstallSteam.click();
    }
}
