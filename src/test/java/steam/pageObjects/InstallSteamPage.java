package steam.pageObjects;

import frame.elements.Button;
import org.openqa.selenium.By;

public class InstallSteamPage extends BaseSteamPage {

    private static String steamLogo = "//div[@class='steam_logo']";
    private Button btnDownloadSteam = new Button(By.xpath("//a[@class='about_install_steam_link']"), "download Steam button");

    public InstallSteamPage() {
        super(driver);
    }

    public void checkInstallSteamPageOpened() {
        assertIsOpenedPage(steamLogo);
    }

    public void downloadSteam() {
        btnDownloadSteam.click();
    }

    public void checkFileName(String fileName) {
        //checkFileNameAndKill(fileName);
    }
}
