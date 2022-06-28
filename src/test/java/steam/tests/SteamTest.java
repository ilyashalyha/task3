package steam.tests;

import framework.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steam.pageObject.*;

public class SteamTest extends BaseTest {

    @Parameters({"fileName"})
    @Test
    public void runTest(String fileName) {
        MainPage mainPage = new MainPage();
        mainPage.setLocale("en");
        mainPage.navigateMenu();
        ActionPage actionPage = new ActionPage();
        actionPage.selectMaxDiscount();
        AgeForm ageForm = new AgeForm();
        ageForm.checkForAgeForm();
        GamePage gamePage = new GamePage();
        gamePage.checkGamePage(actionPage.maxDiscountValue);
        gamePage.clickInstallSteamButton();
        InstallSteamPage installSteamPage = new InstallSteamPage();
        installSteamPage.downloadSteam();
        installSteamPage.checkFileName(fileName);
    }
}
