package steam.tests;

import frame.BaseTest;
import steam.pageObjects.*;

public class SteamTest extends BaseTest {

    public void runTest(String fileName) {
        MainPage mainPage = new MainPage();
        mainPage.setLocale("en");
        mainPage.navigateMenu();
        ActionPage actionPage = new ActionPage();
        actionPage.checkOpenedPage();
        actionPage.selectMaxDiscount();
        AgeForm ageForm = new AgeForm();
        ageForm.checkForAgeForm();
        GamePage gamePage = new GamePage();
        gamePage.checkGamePage(actionPage.maxDiscountValue);
        gamePage.clickInstallSteamButton();
        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.checkInstallSteamPageOpened();
        installSteamPage.downloadSteam();
        installSteamPage.checkFileName(fileName);
    }
}
