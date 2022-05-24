package steam.tests.forms;

import frame.BaseForm;
import org.openqa.selenium.By;

import static frame.Browser.driver;

public class GamePage extends BaseForm {

    public void clickInstallSteamButton() {
        driver.findElement(By.xpath("//a[@class='header_installsteam_btn_content']")).click();
    }
}
