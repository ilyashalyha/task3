package steam.tests.forms;

import frame.BaseForm;
import frame.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

import static frame.Browser.driver;

public class InstallSteamPage extends BaseSteamPage {

    private static String steamLogo = "//div[@class='steam_logo']";
    private Button btnDownloadSteam = new Button(By.xpath("//a[@class='about_install_steam_link']"), "download Steam button");

    public void checkInstallSteamPageOpened() {
        assertIsOpenedPage(steamLogo);
    }

    public void downloadSteam() {
        btnDownloadSteam.click();
    }


}
