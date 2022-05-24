package steam.tests.forms;

import frame.BaseForm;
import org.openqa.selenium.By;
import org.testng.Assert;

import static frame.Browser.driver;

public class InstallSteamPage extends BaseForm {

    public void checkInstallSteamPageOpened() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='steam_logo']")).isDisplayed());
    }

    public void downloadSteam() {
        driver.findElement(By.xpath("//a[@class='about_install_steam_link']")).click();
    }
}
