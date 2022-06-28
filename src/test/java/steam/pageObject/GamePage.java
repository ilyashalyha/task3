package steam.pageObject;

import framework.elements.Button;
import framework.elements.InfoField;
import org.openqa.selenium.By;

public class GamePage extends BaseSteamPage {

    private static InfoField fldDiscount = new InfoField(By.xpath("//div[@class='discount_block game_purchase_discount']/div[@class='discount_pct']"), "Actions header");
    private Button btnInstallSteam = new Button(By.xpath("//a[@class='header_installsteam_btn_content']"), "install Steam button");

    public GamePage() {
        super(By.xpath(fldDiscount.getLocator()), "Actions header");
    }


    public void checkGamePage(String value) {
        checkOpenedPageByText(fldDiscount.getElement().getText().substring(1, 3), value);
    }

    public void clickInstallSteamButton() {
        btnInstallSteam.click();
    }
}
